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
                .roles("USER")
                .and()
                .withUser("bar")
                .password("bar")
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Top To Bottom: Most Restrictive -> Least Restrictive
        http.authorizeRequests()
//                .antMatchers("/db/**").permitAll()
                .antMatchers("/adminlevel").hasRole("ADMIN")
                .antMatchers("/userlevel").hasAnyRole("ADMIN","USER")
                .antMatchers("/","static/css", "static/js", "static/images", "/db/**").permitAll()
                .and()
                .formLogin();

        // Required For H2 Console
        // TODO: Remove this when H2 no longer needed
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

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
