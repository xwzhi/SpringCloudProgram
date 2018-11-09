package com.py.property.until;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName StringUtils
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-29 14:42 星期一 MyProgram
 * @VERSION 1.0.0
 **/
public class StringUtils {


    /**
     * MD5算法加密，Base64算法编码
     */
    public static String StringToMd5(String msg) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 明文
            byte[] input = msg.getBytes();
            // 密文
            byte[] output = md.digest(input);
            // Base64编码
            String s = Base64.encodeBase64String(output);
            return s;
        } catch (Exception ex) {
            throw new RuntimeException("加密失败");
        }
    }

    /**
     * 判断数据库密码和用户输入密码是否一致
     */
    public static boolean checkPassword(String newPassword, String oldPassword) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (StringToMd5(newPassword).equals(oldPassword)) {
            return true;
        } else
            return false;
    }

    /**
     * 判断是否为空
     */
    public static boolean isNotEmpty(Object str) {
        boolean flag = true;
        if (str != null && !str.equals("")) {
            if (str.toString().length() > 0) {
                flag = true;
            }
        } else {
            flag = false;
        }
        return flag;
    }

    @Test
    public void test1() {
        System.out.println("\u0061");
        Integer a = 0x0061;
        System.out.println("\u0007" + Integer.toHexString(16));
        int a1[] = {1, 2, 3};
    }

}
