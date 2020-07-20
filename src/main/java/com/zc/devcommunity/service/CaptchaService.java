package com.zc.devcommunity.service;

import com.zc.devcommunity.pojo.Captcha;

import java.io.IOException;

/**
 * 验证码service
 */

public interface CaptchaService {

    Captcha createCaptcha() throws IOException;

}
