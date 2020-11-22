package imageboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import imageboard.bean.ImageboardDTO;

public class ImageboardDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "javaexam";
	private String password = "m1234";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ImageboardDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// insert
	public int imageboardWrite(ImageboardDTO imageboardDTO) {
		int su = 0;
		String sql = "insert into imageboard values" 
				   + "(seq_imageboard.nextval, ?, ?, ?, ?, ?, ?, sysdate)";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, imageboardDTO.getImageId());
			pstmt.setString(2, imageboardDTO.getImageName());
			pstmt.setInt(3, imageboardDTO.getImagePrice());
			pstmt.setInt(4, imageboardDTO.getImageQty());
			pstmt.setString(5, imageboardDTO.getImageContent());
			pstmt.setString(6, imageboardDTO.getImage1());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	// delete
	public int imageboardDelete(int seq) {
		int su = 0;
		String sql = "delete imageboard where seq=?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq); 
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	// 목록보기
	public List<ImageboardDTO> imageboardList(int startNum, int endNum) {
		List<ImageboardDTO> list = new ArrayList<ImageboardDTO>();
		String sql = "select * from " 
				   + " (select rownum rn, tt.* from " 
				   + " (select * from imageboard order by seq desc) tt) " 
				   + " where rn>=? and rn<=?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ImageboardDTO imageboardDTO = new ImageboardDTO();
				imageboardDTO.setSeq(rs.getInt("seq"));
				imageboardDTO.setImageId(rs.getString("imageId"));
				imageboardDTO.setImageName(rs.getString("imageName"));
				imageboardDTO.setImagePrice(rs.getInt("imagePrice"));
				imageboardDTO.setImageQty(rs.getInt("imageQty"));
				imageboardDTO.setImageContent(rs.getString("imageContent"));
				imageboardDTO.setImage1(rs.getString("image1"));
				imageboardDTO.setLogtime(rs.getString("logtime"));
				// 리스트에 저장
				list.add(imageboardDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	// 상세보기
	public ImageboardDTO imageboardView(int seq) {
		ImageboardDTO imageboardDTO = null;
		String sql = "select * from imageboard where seq = ?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				imageboardDTO = new ImageboardDTO();
				imageboardDTO.setSeq(rs.getInt("seq"));
				imageboardDTO.setImageId(rs.getString("imageId"));
				imageboardDTO.setImageName(rs.getString("imageName"));
				imageboardDTO.setImagePrice(rs.getInt("imagePrice"));
				imageboardDTO.setImageQty(rs.getInt("imageQty"));
				imageboardDTO.setImageContent(rs.getString("imageContent"));
				imageboardDTO.setImage1(rs.getString("image1"));
				imageboardDTO.setLogtime(rs.getString("logtime"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return imageboardDTO;
	}
	// 총록수
	public int getTotalA() {
		int totalA = 0;
		String sql = "select count(*) as cnt from imageboard";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalA = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return totalA;
	}
	
}













