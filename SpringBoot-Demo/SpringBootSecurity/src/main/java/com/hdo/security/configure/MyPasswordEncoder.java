package com.hdo.security.configure;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName MyPasswordEncoder
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-09-12 15:16 星期三 SpringBootProgram
 * @VERSION 1.0.0
 **/
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
