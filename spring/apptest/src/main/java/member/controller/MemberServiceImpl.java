package member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import files.bean.FilesDTO;
import files.dao.FilesDAO;
import member.bean.MemberDTO;
import member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDAO;
	@Autowired
	FilesDAO filesDAO;
	
	
	@Override
	public int memberWrite(MemberDTO memberDTO) {
		return memberDAO.memberWrite(memberDTO);
	}

	@Override
	public List<MemberDTO> memberList() {
		return memberDAO.memberList();
	}

	@Override
	public int getMemberFirstSeq() {
		return filesDAO.getMemberFirstSeq();
	}

	@Override
	public int filesWrite(FilesDTO filesDTO) {
		return filesDAO.filesWrite(filesDTO);
	}
	
	@Override
	public String checkFiles(int member_seq) {
		return filesDAO.checkFiles(member_seq);
	}

}
