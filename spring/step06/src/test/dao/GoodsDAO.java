package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import test.bean.GoodsVO;

@Repository
public class GoodsDAO {
	// JDBC 관련 변수
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// SQL 명령어
	String goods_insert = "insert into goods values (?, ?, ?, ?)";
	String goods_delete = "delete goods where code=?";
	String goods_get = "select * from goods where code=?";
	String goods_list = "select * from goods";
	
	/** CRUD 기능의 메소드 구현 **/
	// 책 등록
	public int insertGoods(GoodsVO vo) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(goods_insert);
			pstmt.setString(1, vo.getCode());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getPrice());			
			pstmt.setString(4, vo.getMaker());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return result;
	}
	// 책 목록 조회
	public List<GoodsVO> getGoodsList() {
		List<GoodsVO> list = new ArrayList<GoodsVO>();
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(goods_list);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GoodsVO vo = new GoodsVO();
				vo.setCode(rs.getString("code"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setMaker(rs.getString("maker"));
				// 리스트에 저장
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return list;
	}
	
	// 책 상세 조회
	/*
	public GoodsVO getGoods(GoodsVO vo) {
		
	}
	*/
	
	// 책 삭제
	/*
	public int deleteGoods(GoodsVO vo) {
		
	}
	*/
}








