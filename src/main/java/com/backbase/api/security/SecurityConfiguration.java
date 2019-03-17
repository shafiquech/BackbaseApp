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
            .antMatchers("/api/**") // Restrict all urls
            .authenticated(); // Use Basic authentication
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Custom authentication provider - Order 1
        auth.authenticationProvider(customAuthenticationProvider);
        // Built-in authentication provider - Order 2
        auth.inMemoryAuthentication()
            .withUser(Constants.ADMIN_USER)
            .password(Constants.ADMIN_PASSWORD)
            .roles(Constants.ADMIN_ROLE) // Role of the user
            .and()
            .withUser(Constants.USER_USER)
            .password(Constants.USER_PASSWORD)
            .credentialsExpired(true)
            .accountExpired(true)
            .accountLocked(true)
            .roles(Constants.USER_ROLE);
    }
}
