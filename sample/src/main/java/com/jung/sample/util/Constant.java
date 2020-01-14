package com.jung.sample.util;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import com.jung.sample.dao.TestDao;



public class Constant {
	public static JdbcTemplate template; 
	public static PlatformTransactionManager transactionManager;
	public static TestDao dao;
}
