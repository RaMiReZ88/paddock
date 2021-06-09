package com.kolhoz.paddock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("");

//        http.formLogin(login -> login
//                .loginPage("")
//                .usernameParameter("")
//                .passwordParameter("")
//                .successForwardUrl("/home")
//                .failureForwardUrl("/login")
//        ).httpBasic();
//
//        http.logout(logout -> logout
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/my/index")
////                .logoutSuccessHandler()
//                .invalidateHttpSession(true)
////                .addLogoutHandler()
////                .deleteCookies()
//        ).httpBasic();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService().passwordEncoder()
    }

    @Bean
    public BCryptPasswordEncoder getBCryotPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
