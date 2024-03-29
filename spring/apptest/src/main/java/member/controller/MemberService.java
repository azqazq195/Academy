package member.controller;

import java.util.List;

import files.bean.FilesDTO;
import member.bean.MemberDTO;

public interface MemberService {
	public int memberWrite(MemberDTO memberDTO);
	
	public List<MemberDTO> memberList();
	
	public int getMemberFirstSeq();
	
	public int filesWrite(FilesDTO filesDTO);
	
	public String checkFiles(int member_seq);
}
