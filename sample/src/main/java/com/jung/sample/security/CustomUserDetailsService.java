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

//spring security�� ����ϸ� Ŭ���̾�Ʈ���� ��û(login)�ϸ� �̰����� ��û��
public class CustomUserDetailsService implements UserDetailsService {
	@Override //security���� ȣ���ϴ� �޼���
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Ŀ���� ���� �Է°� : " + username);
		
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
		
		System.out.println("���̵� : " + username);
		System.out.println("�н����� : " + pw);
		System.out.println("���� : "+ roles);

		return user;
	}
}
