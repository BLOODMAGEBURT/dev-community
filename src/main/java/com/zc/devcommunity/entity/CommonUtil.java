package com.zc.devcommunity.entity;


import java.security.MessageDigest;


/**
 * @author admin
 * @version 1.0.0
 * @ClassName CommonUtil.java
 * @Description 通用工具类
 * @createTime 2020年07月21日 11:00:00
 */
public class CommonUtil {

    /**
     * 生成32位的MD5签名串
     *
     * @param source      待签名串
     * @param toUpperCase 是否转大写
     * @return
     */
    public static String md5(String source, boolean toUpperCase) {


        StringBuilder sb = new StringBuilder(32);

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(source.getBytes("utf-8"));

            for (int i = 0; i < array.length; i++) {
                if (toUpperCase) {
                    sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).toUpperCase().substring(1, 3));
                } else {
                    sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
                }
            }
        } catch (Exception e) {

            System.out.println("Can not encode the string '" + source + "' to MD5!");
            throw new RuntimeException(e);
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(md5("abc123", true));
    }
}
