package com.zc.devcommunity.service.impl;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.zc.devcommunity.entity.RedisUtils;
import com.zc.devcommunity.pojo.Captcha;
import com.zc.devcommunity.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

import static com.zc.devcommunity.entity.CacheKey.CAPTCHA_KEY;

@Service
public class CaptchaServiceImpl implements CaptchaService {
    // 默认300s, 5m
    @Value("${server.session.timeout:300}")
    Long timeout;

    @Autowired
    DefaultKaptcha producer;

    @Autowired
    RedisUtils redisUtils;


    @Override
    public Captcha createCaptcha() throws IOException {


        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);

        // 将图片base64编码
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);

        String str = "data:image/jpeg;base64,";
        String base64Img = str + Base64.getEncoder().encodeToString(outputStream.toByteArray()).replace("\n", "").replace("\r", "");

        Captcha captcha = new Captcha();
        // 生成一个随机标识符
        String captchaKey = UUID.randomUUID().toString();
        captcha.setCaptchaKey(captchaKey);
        captcha.setBase64Img(base64Img);
        captcha.setExpire(timeout);

        // 保存进redis,缓存验证码并设置过期时间5m
        redisUtils.set(CAPTCHA_KEY.concat(captchaKey), text, timeout);


        return captcha;
    }
}
