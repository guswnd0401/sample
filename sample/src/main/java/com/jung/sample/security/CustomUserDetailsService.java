package com.jung.sample.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jung.sample.dao.TestDao;
import com.jung.sample.dto.JoinDto;
import com.jung.sample.util.Constant;

//spring security�� ����ϸ� Ŭ���̾�Ʈ���� ��û(login)�ϸ� �̰����� ��û��
public class CustomUserDetailsService implements UserDetailsService {
	@Override //security���� ȣ���ϴ� �޼���
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		
		TestDao dao = Constant.dao;
		JoinDto dto = dao.login(username);
		if(dto == null) {
			System.out.println("null");
			throw  new UsernameNotFoundException("No user found with username");
		}
		
		String pw = dto.getuPw();
		
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		UserDetails user = new User(username, pw, roles);

		return user;
	}
}
