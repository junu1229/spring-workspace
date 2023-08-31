package com.kh.mvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisUnitTest {
	
	public SqlSession getSession() {
		try { 
			Reader r = Resources.getResourceAsReader("mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
			return factory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
	 	}
		return null;
	}
	
	@Test
	public void insertTest() {
		SqlSession session = getSession();
		Board board = new Board();
		board.setTitle("test");
		board.setContent("test");
		board.setWriter("test");
		System.out.println("db before :: " + board.getNo());
		int result = session.insert("board.insert", board);
		if(result > 0) {
			System.out.println(result + "개 게시글 추가!");
			session.commit();
		}
		System.out.println("db after :: " + board.getNo());
		System.out.println("==========================================");
	}
	
	@Test
	public void selectAllTest() {
		SqlSession session = getSession();
		List<Board> list = session.selectList("board.selectAll");
		for(Board b:list) {
			System.out.println(b);
		}
		System.out.println("==========================================");
	}
	
	@Test
	public void selectTest() {
		SqlSession session = getSession();
		String s = "t";
		List<Board> list = session.selectList("board.select", s);
		for(Board b:list) {
			System.out.println(b);
		}
		System.out.println("==========================================");
	}
	
	@Test
	public void updateTest() {
		SqlSession session = getSession();
		Board board = new Board();
		board.setContent("test2");
		board.setTitle("test2");
		board.setNo(0);
		board.setWriter("test");
		int result = session.insert("board.update", board);
		if(result > 0) {
			System.out.println(result + "개 게시글 수정!");
			session.commit();
		}
		System.out.println("db after :: " + board);
		System.out.println("==========================================");
	}
	
	@Test
	public void deleteTest() {
		SqlSession session = getSession();
		int result = session.delete("board.delete", 2);
		if(result > 0) {
			System.out.println(result + "개 게시글 삭제!");
			session.commit();
		}
		System.out.println("==========================================");
	}
	
}
