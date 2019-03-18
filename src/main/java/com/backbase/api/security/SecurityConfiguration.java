package com.backbase.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.backbase.api.util.Constants;

/**
 * 
 * @author shafique
 * 
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomAuthenticationProvider.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {

	@Autowired
    CustomAuthenticationProvider customAuthenticationProvider;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers("/api/**") // Restrict only api urls
            .authenticated(); 
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
        //default authentication - fall-back strategy
        auth.inMemoryAuthentication()
            .withUser(Constants.ADMIN_USER)
            .password(Constants.ADMIN_PASSWORD)
            .roles(Constants.ADMIN_ROLE)
            .and()
            .withUser(Constants.USER_USER)
            .password(Constants.USER_PASSWORD)
            .credentialsExpired(true)
            .accountExpired(true)
            .accountLocked(true)
            .roles(Constants.USER_ROLE);
    }
}
