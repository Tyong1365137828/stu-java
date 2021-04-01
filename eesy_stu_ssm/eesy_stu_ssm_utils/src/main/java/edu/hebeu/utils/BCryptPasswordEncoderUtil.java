package edu.hebeu.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * SpringSecurity提供的这个类，用来实现加密操作
 */
public class BCryptPasswordEncoderUtil {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * 将字符串加密
     * @param str
     * @return
     */
    public static String toEncode(String str) {
        return bCryptPasswordEncoder.encode(str);
    }

    public static void main(String[] args) {
        String s = "072731";
        System.out.println(toEncode(s));
    }
}
