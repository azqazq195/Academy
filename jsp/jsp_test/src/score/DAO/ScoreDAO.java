package score.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import score.bean.ScoreDTO;

public class ScoreDAO {
		
	   String driver = "oracle.jdbc.driver.OracleDriver";
	   String url = "jdbc:oracle:thin:@localhost:1521:xe";
	   String user = "javaexam";
	   String password = "m1234";
	   
	   Connection conn;
	   PreparedStatement pstmt;
	   ResultSet rs;
	   
	   
	   public ScoreDAO() {
	      try {
	         Class.forName(driver);
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      }
	   }
	   public Connection getConnection() {
	      try {
	         conn = DriverManager.getConnection(url, user, password);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return conn;
	   }
	   
	   public void close(){
	      try {
	         if (rs!=null) rs.close();
	         if (pstmt!=null) pstmt.close();
	         if (conn!=null) conn.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public int input(ScoreDTO dto) {
//		   System.out.println(dto.getHak());
//		   System.out.println(dto.getName());
//		   System.out.println(dto.getKor());
//		   System.out.println(dto.getEng());
//		   System.out.println(dto.getMat());
//		   System.out.println(dto.getTot());
//		   System.out.println(dto.getAvg());
		   int su = 0;
		   String sql = "insert into score values(?,?,?,?,?,?,?)";
		   conn = getConnection();
		   try {
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setInt(1, dto.getHak());
		         pstmt.setString(2, dto.getName());
		         pstmt.setInt(3, dto.getKor());
		         pstmt.setInt(4, dto.getEng());
		         pstmt.setInt(5, dto.getMat());
		         pstmt.setInt(6, dto.getTot());
		         pstmt.setDouble(7, dto.getAvg());
		         
		         su = pstmt.executeUpdate();
		   } catch (SQLException e) {
		         e.printStackTrace();
		   } finally {
		         close();
		   }
		   return su;
	   }
	   
	   public List<ScoreDTO> scorelist(int start, int end){
		  List<ScoreDTO> list = new ArrayList<ScoreDTO>();
		  String sql = "select * from (select rownum rn, tt.* from "
				  	+ " (select * from score order by hak asc) tt) "
					+ " where rn>=? and rn<=?";		  
		  	
			try {
			 conn = getConnection();
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, start);
			 pstmt.setInt(2, end);
			 rs = pstmt.executeQuery();
				
			 while (rs.next()) {
				ScoreDTO dto = new ScoreDTO();
				dto.setHak(rs.getInt("hak"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getDouble("avg"));
				
				list.add(dto);
			 }	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return list;
	   }
	   
	   public int getTotA() {
		   int totalA = 0;
		   String sql = "SELECT COUNT(*) as cnt FROM score";
		   
		   try {
			conn = getConnection();
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
