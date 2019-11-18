package com.mvn.test.controller;

import java.io.InputStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mvn.test.dao.impl.UserInfoDAOImpl;

// loadOnStartup (서버가 켜질 때 실행되는 것) => preloading (요청이 들어오기 전에)
@WebServlet(loadOnStartup = 1)
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static SqlSessionFactory ssf;
    static {
		String path = "/config/mybatis-config.xml";
		InputStream is = UserInfoDAOImpl.class.getResourceAsStream(path);
		ssf = new SqlSessionFactoryBuilder().build(is);
    }
	
	// DAO에서 중요한 건 sql factory가 아니라 sql session!
	public static SqlSession getSqlSession() {
		return ssf.openSession();
	}
}
