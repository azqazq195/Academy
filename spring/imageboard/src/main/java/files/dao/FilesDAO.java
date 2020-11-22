package files.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import files.bean.FilesDTO;

@Repository
public class FilesDAO {
   
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int getCommunityFirstSeq() {
		return sqlSession.selectOne("mybatis.filesMapper.getCommunityFirstSeq");
	}
	
	public int filesWrite(FilesDTO filesDTO) {
		return sqlSession.insert("mybatis.filesMapper.filesWrite", filesDTO);
	}
	
	public String checkFiles(int community_seq) {
		return sqlSession.selectOne("mybatis.filesMapper.checkFiles", community_seq);
	}
	
	public int filesDelete(int community_seq, String filePath) {
		int su = sqlSession.delete("mybatis.filesMapper.filesDelete", community_seq);
		if(su > 0) {
       	 File file = new File(filePath);
            file.delete();
        }
		return su;
	}
	
	// 수정
//	public int filesUpdate(FilesDTO filesDTO) {
//		int result = 0;
//	      String sql = "UPDATE FILES SET"
//	      		+ " DIR = ?, FILENAME = ?, ORIGINNAME = ?, FILESIZE = ?, FILETYPE = ?"
//	      		+ " WHERE COMMUNITY_SEQ = ?";
//	      conn = getConnection();
//	      try {
//	         pstmt = conn.prepareStatement(sql);
//	         pstmt.setString(1, filesDTO.getDir());
//	         pstmt.setString(2, filesDTO.getFilename());
//	         pstmt.setString(3, filesDTO.getOriginname());
//	         pstmt.setInt(4, filesDTO.getFilesize());
//	         pstmt.setString(5, filesDTO.getFiletype());
//	         pstmt.setInt(6, filesDTO.getCommunity_seq());
//	         result = pstmt.executeUpdate();
//	      } catch (SQLException e) {
//	         e.printStackTrace();
//	      } finally {
//	         close();
//	      }
//	      return result;
//	}
	
}