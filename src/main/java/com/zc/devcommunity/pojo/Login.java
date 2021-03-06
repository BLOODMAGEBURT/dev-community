package com.zc.devcommunity.pojo;

import java.io.Serializable;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Login.java
 * @Description 登陆pojo
 * @createTime 2020年07月20日 18:09:00
 */
public class Login implements Serializable {
    private String userName;

    private String password;

    private String captchaKey;

    private String captcha;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptchaKey() {
        return captchaKey;
    }

    public void setCaptchaKey(String captchaKey) {
        this.captchaKey = captchaKey;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
