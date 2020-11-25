package com.uzenetesztek.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("foo")
                .password("foo")
                .roles("USER");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    //    @Autowired
//    protected void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
//         auth.inMemoryAuthentication()
//                 .withUser("test2")
//                 .password("pass")
//                 .roles("USER")
//             .and()
//                 .withUser("testAdmin")
//                 .password("pass")
//                 .roles("ADMIN")
//             ;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/profile").hasRole("ADMIN")
//                .antMatchers("/css/**", "/js/**", "/images/**").permitAll()
//                .antMatchers("/registration").permitAll()
//                .antMatchers("/reg").permitAll()
//                .antMatchers("/db/**").permitAll() // TODO: Remove when migrating from H2
//                .anyRequest().authenticated()
//            .and()
//                .formLogin()
////                    .loginPage("/login")
//                    .permitAll()
//            .and()
//                .logout()
//                    .logoutSuccessUrl("/login?logout")
//                    .permitAll();
//    }
}
