package com.curso.springboot.backend.apirest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.springboot.backend.apirest.dao.IUserDao;
import com.curso.springboot.backend.apirest.entity.User;

@Service
public class UserService implements IUsuarioService ,UserDetailsService{
	
	private Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDao.findByUsername(username);
		
		if(user == null) {
			log.error("Error en el login: no existe el usuario " + username);
			throw new UsernameNotFoundException("Error en el login: no existe el usuario " + username);
		}
		
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRolename()))
				.peek(authority -> log.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
