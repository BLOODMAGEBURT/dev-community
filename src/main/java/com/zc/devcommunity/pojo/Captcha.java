package com.zc.devcommunity.pojo;

/**
 * @author xujianbo
 * @version 1.0.0
 * @ClassName Captcha.java
 * @Description 验证码pojo
 * @createTime 2020年07月20日 17:56:00
 */
public class Captcha {
    /**
     * 验证码标识符
     */
    private String captchaKey;
    /**
     * 验证码过期时间
     */
    private Long expire;
    /**
     * base64字符串
     */
    private String base64Img;

    public String getCaptchaKey() {
        return captchaKey;
    }

    public void setCaptchaKey(String captchaKey) {
        this.captchaKey = captchaKey;
    }

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }

    public String getBase64Img() {
        return base64Img;
    }

    public void setBase64Img(String base64Img) {
        this.base64Img = base64Img;
    }
}
