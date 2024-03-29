package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.bean.MemberDTO;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "javaexam";
	String password = "m1234";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	// 1. driver 라이브러리가 등록되었는 지 확인
	public MemberDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// 2. 커넥션 객체 얻기
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	// 커넥션 객체 닫기
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 데이터 추가하기
	public int write(MemberDTO memberDTO) {
		int su = 0;
		String sql = "insert into member values (?,?,?,?,?,?,?,?,?,?, sysdate)";
		// (1) db 연결
		conn = getConnection();
		try {
			// (2) 보조 스트림 객체 생성 : PreparedStatement
			pstmt = conn.prepareStatement(sql);
			// (3) sql문 완성
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
			pstmt.setString(7, memberDTO.getTel1());
			pstmt.setString(8, memberDTO.getTel2());
			pstmt.setString(9, memberDTO.getTel3());
			pstmt.setString(10, memberDTO.getAddr());
			// (4) sql문 실행 요청 -> db에서 데이터 처리 -> 처리된 결과를 pstmt가 받아서 리턴
			// => 리턴값 : insert, delete, update : 처리된 데이터 갯수
			//            select : 처리된  데이터 문자열 -> ResultSet 객체 리턴 
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// (5) db 연결 끊기
			close();
		}
		return su;
	}
	// 회원정보 수정
	public int modify(MemberDTO memberDTO) {
		int su = 0;
		String sql = "update member set name=?, pwd=?, gender=?, " 
				   + "email1=?, email2=?, tel1=?, tel2=?, tel3=?, addr=? " 
				   + " where id=?";
		// (1) db 연결
		conn = getConnection();
		try {
			// (2) 보조 스트림 객체 생성 : PreparedStatement
			pstmt = conn.prepareStatement(sql);
			// (3) sql문 완성
			pstmt.setString(1, memberDTO.getName());			
			pstmt.setString(2, memberDTO.getPwd());
			pstmt.setString(3, memberDTO.getGender());
			pstmt.setString(4, memberDTO.getEmail1());
			pstmt.setString(5, memberDTO.getEmail2());
			pstmt.setString(6, memberDTO.getTel1());
			pstmt.setString(7, memberDTO.getTel2());
			pstmt.setString(8, memberDTO.getTel3());
			pstmt.setString(9, memberDTO.getAddr());
			pstmt.setString(10, memberDTO.getId());
			// (4) sql문 실행 요청 -> db에서 데이터 처리 -> 처리된 결과를 pstmt가 받아서 리턴
			// => 리턴값 : insert, delete, update : 처리된 데이터 갯수
			//            select : 처리된  데이터 문자열 -> ResultSet 객체 리턴 
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// (5) db 연결 끊기
			close();
		}
		return su;
	}
	// 로그인 처리
	public String login(String id, String pwd) {
		String name = null;
		String sql = "select * from member where id=? and pwd=?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); 
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return name;
	}
	// id 확인
	public boolean isExistId(String id) {
		boolean exist = false;
		String sql = "select * from member where id=?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); 
			rs = pstmt.executeQuery();
			if(rs.next()) {  // rs.next() 이 true이면 그런 id가 존재한다는 의미이다.
				exist = true;  // id가 있음을 나타냄
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return exist;
	}
	// 1명데이터 가져오기
	public MemberDTO getMember(String id) {
		MemberDTO memberDTO = null;
		String sql = "select * from member where id=?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); 
			rs = pstmt.executeQuery();
			if(rs.next()) {  // rs.next() 이 true이면 그런 id가 존재한다는 의미이다.
				memberDTO = new MemberDTO();
				memberDTO.setName(rs.getString("name"));
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPwd(rs.getString("pwd"));
				memberDTO.setGender(rs.getString("gender"));
				memberDTO.setEmail1(rs.getString("email1"));
				memberDTO.setEmail2(rs.getString("email2"));
				memberDTO.setTel1(rs.getString("tel1"));
				memberDTO.setTel2(rs.getString("tel2"));
				memberDTO.setTel3(rs.getString("tel3"));
				memberDTO.setAddr(rs.getString("addr"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return memberDTO;
	}
	// 회원 5명씩 데이터 얻기
	public List<MemberDTO> selectList(int startNum, int endNum) {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		String sql = "select * from " 
				+ " (select rownum rn, tt.* from " 
				+ " (select * from member order by name asc) tt) " 
				+ " where rn>=? and rn<=?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum); 
			pstmt.setInt(2, endNum); 
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setName(rs.getNString("name"));
				memberDTO.setId(rs.getNString("id"));
				memberDTO.setPwd(rs.getNString("pwd"));
				memberDTO.setGender(rs.getNString("gender"));
				memberDTO.setEmail1(rs.getNString("email1"));
				memberDTO.setEmail2(rs.getNString("email2"));
				memberDTO.setTel1(rs.getNString("tel1"));
				memberDTO.setTel2(rs.getNString("tel2"));
				memberDTO.setTel3(rs.getNString("tel3"));
				memberDTO.setAddr(rs.getNString("addr"));
				memberDTO.setLogtime(rs.getNString("logtime"));
				// 리스트에 저장
				list.add(memberDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	// 총회원수 구하기
	public int getTotalMember() {
		int totalMember = 0;
		String sql = "select count(*) as cnt from member";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalMember = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return totalMember;
	}
	// 회원 삭제
	public int delete(String id) {
		int su = 0;
		String sql = "delete member where id=?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); 
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
}











