package com.example.agilestore14.springsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService());
    }
    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http
                .csrf().disable()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login-error.html")
            .and()
                .logout()
                .logoutSuccessUrl("/index.html");
        /*http.csrf().disable();
        http.authorizeRequests()

                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("ADMIN","USER")
                .antMatchers("/","/Login").permitAll()
                .and().formLogin()
                      .loginPage("/login.html");*/
    }
}
