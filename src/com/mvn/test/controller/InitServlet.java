package com.mvn.test.controller;

import java.io.InputStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mvn.test.dao.impl.UserInfoDAOImpl;

// loadOnStartup (서버가 켜질 때 실행되는 것) => preloading (요청이 들어오기 전에)
@WebServlet(name="Init", urlPatterns = {"/*"}, loadOnStartup = 1)
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// sql 읽을 수 있게 미리 준비해 놓는 것
    private static SqlSessionFactory ssf;
    static {
//    	System.out.println("Servlet과 상관 없이 java가 무조건 실행시키는 것!");
		String path = "/config/mybatis-config.xml";
		InputStream is = UserInfoDAOImpl.class.getResourceAsStream(path);
		ssf = new SqlSessionFactoryBuilder().build(is);
    }
	
    public InitServlet() {
//    	System.out.println("난 서버 켜질 때 실행됨!");
//    	System.out.println("난 해당 메모리가 사라지기 전 1번만 실행됨!");;
    }
    
    public void init() {
//    	System.out.println("난 InitServlet() 실행 후에 실행됨!");;
    }
    
	// DAO에서 중요한 건 sql factory가 아니라 sql session!
	public static SqlSession getSqlSession() {
		return ssf.openSession();
	}
}
