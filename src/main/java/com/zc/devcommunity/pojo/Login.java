package com.zc.devcommunity.pojo;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Login.java
 * @Description 登陆pojo
 * @createTime 2020年07月20日 18:09:00
 */
public class Login {
    private String userName;

    private String pwd;

    private String captchaKey;

    private String captcha;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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
