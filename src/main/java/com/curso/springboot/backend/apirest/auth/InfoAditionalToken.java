package com.curso.springboot.backend.apirest.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.curso.springboot.backend.apirest.entity.User;
import com.curso.springboot.backend.apirest.service.IUsuarioService;

@Component
public class InfoAditionalToken implements TokenEnhancer{

	@Autowired
	private IUsuarioService userService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		User user = userService.findByUsername(authentication.getName());
		Map<String, Object> info = new HashMap<>();
		info.put("name", user.getName());
		info.put("surname", user.getSurname());
		info.put("email", user.getEmail());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
