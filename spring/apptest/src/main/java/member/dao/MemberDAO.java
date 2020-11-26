package member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.bean.MemberDTO;

@Repository
public class MemberDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int memberWrite(MemberDTO memberDTO) {
		return sqlSession.insert("mybatis.memberMapper.memberWrite", memberDTO);
	}
	
	public List<MemberDTO> memberList(){
		return sqlSession.selectList("mybatis.memberMapper.memberList");
	}
}
