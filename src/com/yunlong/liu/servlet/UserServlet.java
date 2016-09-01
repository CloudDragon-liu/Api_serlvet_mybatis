package com.yunlong.liu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yunlong.liu.utils.MyBatisUtil;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Logger logger = LogManager.getLogger(UserServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json; charset=utf-8");
		String dataJson = "{\"name\":\"fly\",\"type\":\"虫子\"}";
		SqlSession session = MyBatisUtil.getSession();
		// User one =
		// session.selectOne("com.yunlong.liu.mapper.userMapper.getUser", 1);
		// dataJson = JsonUtil.obj2json(one);

		// User user = new User();
		// List<User> users =
		// session.selectList("com.yunlong.liu.mapper.userMapper.getUserList",
		// user);
		// dataJson = JsonUtil.obj2json(users);

		logger.debug("DEBUG = " + dataJson);
		logger.error("ERROR = " + dataJson);
		PrintWriter writer = resp.getWriter();
		writer.write(dataJson);
		writer.close();
		session.close();
	}
}
