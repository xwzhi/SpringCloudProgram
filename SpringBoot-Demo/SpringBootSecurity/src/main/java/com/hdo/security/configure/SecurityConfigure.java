package com.hdo.security.configure;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName SecurityConfigure
 * @Author XuWeiZhi
 * @Description 权限认证配置类
 * @Date 2018-09-12 14:37 星期三 SpringBootProgram
 * @VERSION 1.0.0
 **/
@EnableWebSecurity
public class SecurityConfigure extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //定制授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //开启登录功能
        http.formLogin()/*.loginPage("/login").failureUrl("/login-error");*/;
        //1./login来到登录页
        //2.重定向到、Loging/error表示失败
        //3.更多配置详细O(∩_∩)O哈哈~看文档

        //开启自动配置的注销功能
        //1.访问/logout 表示用户注销，清空session
        //2.注销成功返回/login?error
        //3.注销成功访问logoutSuccessUrl("/")
        http.logout().logoutSuccessUrl("/");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        //可以设置内存指定的登录的账号密码,指定角色
        //不加.passwordEncoder(new MyPasswordEncoder())
        //就不是以明文的方式进行匹配，会报错
        //auth.inMemoryAuthentication()
        //        .withUser("zhangsan").password("123456").roles("VIP1","VIP2")
        //        .and()
        //        .withUser("lishi").password("123456").roles("VIP1","VIP2","VIP3");
        //.passwordEncoder(new MyPasswordEncoder())。
        //这样，页面提交时候，密码以明文的方式进行匹配。
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("xuweizhi").password("xuweizhi").roles("VIP1");
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("lishi").password("lishi").roles("VIP1","VIP2","VIP3");;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //设置静态资源不要拦截
        web.ignoring().antMatchers("/static/**","/webjar/**","/resources/**");
    }
}
