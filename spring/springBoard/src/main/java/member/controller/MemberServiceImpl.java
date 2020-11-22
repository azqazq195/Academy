package member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public int write(MemberDTO memberDTO) {
		return memberDAO.write(memberDTO);
	}
	@Override
	public int modify(MemberDTO memberDTO) {
		return memberDAO.modify(memberDTO);
	}
	@Override
	public String login(String id, String pwd) {
		return memberDAO.login(id, pwd);
	}
	@Override
	public boolean isExistId(String id) {
		return memberDAO.isExistId(id);
	}
	@Override
	public MemberDTO getMember(String id) {
		return memberDAO.getMember(id);
	}
	@Override
	public List<MemberDTO> selectList(int startNum, int endNum) {
		return memberDAO.selectList(startNum, endNum);
	}
	@Override
	public int getTotalMember() {
		return memberDAO.getTotalMember();
	}
	@Override
	public int delete(String id) {
		return memberDAO.delete(id);
	}
}
