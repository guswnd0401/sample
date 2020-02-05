package com.jung.sample.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jung.sample.dao.UserDao;
import com.jung.sample.dto.UserDto;
import com.jung.sample.util.Constant;

//spring security를 사용하면 클라이언트에서 요청(login)하면 이곳으로 요청됨
public class CustomUserDetailsService implements UserDetailsService {
	@Override //security에서 호출하는 메서드
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		
		UserDao dao = Constant.dao;
		UserDto dto = dao.login(username);
		if(dto == null) {
			System.out.println("null");
			throw  new UsernameNotFoundException("No user found with username");
		}
		
		String pw = dto.getUser_pw();
		
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		UserDetails user = new User(username, pw, roles);

		return user;
	}
}
