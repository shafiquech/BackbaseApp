package com.backbase.api.security;

import java.util.Collections;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.backbase.api.util.Constants;

/**
 * 
 * @author shafique
 *
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	/**
	 * This is to authenticate with a predefined usernamae and password
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		if (Constants.API_USER_NAME.equals(username) && Constants.API_USER_PASSWORD.equals(password)) {
			return new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList());
		} else {
			throw new BadCredentialsException("Authentication failed");
		}
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return aClass.equals(UsernamePasswordAuthenticationToken.class);
	}

}
