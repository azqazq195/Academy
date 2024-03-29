package files.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import files.bean.FilesDTO;
@Repository
public class FilesDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int getMemberFirstSeq() {
		return sqlSession.selectOne("mybatis.filesMapper.getMemberFirstSeq");
	}
	
	public int filesWrite(FilesDTO filesDTO) {
		return sqlSession.insert("mybatis.filesMapper.filesWrite", filesDTO);
	}
	
	public String checkFiles(int community_seq) {
		return sqlSession.selectOne("mybatis.filesMapper.checkFiles", community_seq);
	}
}
