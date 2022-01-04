package com.kolhoz.paddock.config;

import com.kolhoz.paddock.dao.user.repository.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// TODO:
//  1. OAuth2: ВК, Twitter, Facebook, Reddit
//  2. Добавить cors

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"com.kolhoz.utils.security.context"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    public SecurityConfig(@Lazy UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/auth/**")
//                .authenticated()
//                .and()
//                .httpBasic()
//                .and()
//                .csrf().disable();

//        http.anonymous()
//                .authenticationProvider()

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
//                .deleteCookies()
//        ).httpBasic();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/static/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password(getBCryptPasswordEncoder().encode("123456")).roles("USER");
        auth.userDetailsService(userService).passwordEncoder(getBCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
