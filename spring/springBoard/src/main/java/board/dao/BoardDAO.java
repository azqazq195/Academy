package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.bean.BoardDTO;

@Repository
public class BoardDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	/** 4. CRUD **/
	// insert : 글저장
	public int boardWrite(BoardDTO boardDTO) {
		return sqlSession.insert("mybatis.board.boardWrite", boardDTO);
	}
	// 글수정
	public int boardModify(BoardDTO boardDTO) {
		return sqlSession.update("mybatis.board.boardModify", boardDTO);
	}
	
	// 목록 읽기 - 5개씩 끊어서 읽어오기
	public List<BoardDTO> boardList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.board.boardList", map);
	}
	// 상세보기 : 목록 1개
	public BoardDTO boardView(int seq) {
		return sqlSession.selectOne("mybatis.board.boardView", seq);
	}
	// 조회수 증가
	public void updateHit(int seq) {
		sqlSession.update("mybatis.board.updateHit", seq);
	}
	// 글 삭제
	public int boardDelete(int seq) {
		return sqlSession.delete("mybatis.board.boardDelete", seq);
	}
	// 총 글수 구하기
	public int getTatalA() {
		return sqlSession.selectOne("mybatis.board.getTatalA");
	}
}






















