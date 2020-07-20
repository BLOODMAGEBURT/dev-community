package com.zc.devcommunity.controller;

import com.zc.devcommunity.entity.Result;
import com.zc.devcommunity.entity.StatusCode;
import com.zc.devcommunity.pojo.Captcha;
import com.zc.devcommunity.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/captcha")
@CrossOrigin
public class CaptchaController {

    @Autowired
    CaptchaService captchaService;

    @GetMapping("/get")
    public Result getCaptcha() throws IOException {
        Captcha captcha = captchaService.createCaptcha();
        return new Result(true, StatusCode.OK, "图片获取成功", captcha);
    }
}
