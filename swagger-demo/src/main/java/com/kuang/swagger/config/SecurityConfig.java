package com.kuang.swagger.config;

import com.kuang.swagger.pojo.User;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
  private User user;
  private DataSource dataSource;

  @Override
  //http安全策略
  //授权
  protected void configure(HttpSecurity http) throws Exception {
   //首页所有人可以访问，功能页只有有权限的人才能访问
    http.authorizeRequests()
            .antMatchers("/").permitAll()
            //swagger-ui页面只有vip1以上权限才能访问
            .antMatchers("/").hasRole("vip1");
       //没有权限则默认跳转login
      http.formLogin();
      http.csrf().disable();//关闭csrf功能
      //注销.开启了注销功能,如果成功注销则跳转到/页面
      http.logout().logoutSuccessUrl("/");
      //开启记住我功能 cookie,默认保存2周
      http.rememberMe();
  }
  //重写方法
  //认证
  //密码编码：passwordEncoder 密码没被加密会报错
  //在spring Security 5.0+新增很多加密方法（为了保证安全）
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema()
////        .usersByUsernameQuery("select name,pwd from user WHERE name=?")
////        .passwordEncoder(new BCryptPasswordEncoder());

    auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
            .withUser("huang").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
  }
}
