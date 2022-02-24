package com.Project.Roommate.config;

import com.Project.Roommate.config.auth.Principalservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Principalservice principalservice;

    @Bean//비밀번호 해쉬쉬
    public BCryptPasswordEncoder encodePWD(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(principalservice).passwordEncoder(encodePWD());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/Roommate/**")
                .permitAll()
             .and()
                .formLogin()
                .loginPage("/Roommate/main")
                .loginProcessingUrl("/Roommate/loginprob")
                .usernameParameter("userid")
                .passwordParameter("userpw")
                .defaultSuccessUrl("/Roommate/main",true)
                .and()
                .logout()
                .logoutUrl("/Roommate/logout")
                .logoutSuccessUrl("/Roommate/main");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**")
                .antMatchers("/css/**")
                .antMatchers("/assets/**")
                .antMatchers("/js/**")
                .antMatchers("/img/**");
    }


}
