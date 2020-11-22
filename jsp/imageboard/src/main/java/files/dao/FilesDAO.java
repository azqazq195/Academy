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
	
	// Community 테이블의 마지막 저장된 seq값 얻어오기
	public int getCommunityFirstSeq() {		
		return sqlSession.selectOne("mybatis.filesMapper.getCommunityFirstSeq");
	}
	
	// 입력 내용 저장
	public int filesWrite(FilesDTO filesDTO) {		
		return sqlSession.insert("mybatis.filesMapper.filesWrite", filesDTO);
	}
	
	// 파일이 있는 지 검사 
	public String checkFiles(int community_seq) { 
		return sqlSession.selectOne("mybatis.filesMapper.checkFiles", community_seq);
	}
	// 파일 삭제 : 1. db 삭제   2. 실제 파일 삭제
	public int filesDelete(int community_seq, String filePath) {
		int su = sqlSession.delete("mybatis.filesMapper.filesDelete", community_seq);
		if(su > 0) {  // 파일 삭제
			File file = new File(filePath);
			file.delete();
		}		
		return su;
	}
}











