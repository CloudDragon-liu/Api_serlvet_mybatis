package com.yunlong.liu.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	public static SqlSession getSession() {
		InputStream is = null;
		SqlSession session = null;
		try {
			is = MyBatisUtil.class.getClassLoader().getResourceAsStream("mybatis-conf.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
			session = sessionFactory.openSession();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return session;
	}

	public static void main(String[] args) {
		MyBatisUtil.getSession();
	}
}
