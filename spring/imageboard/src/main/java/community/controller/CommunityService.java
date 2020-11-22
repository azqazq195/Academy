package community.controller;

import java.io.File;
import java.util.List;
import community.bean.CommunityDTO;
import files.bean.FilesDTO;

public interface CommunityService {
	// 입력내용 저장
	public int communityWrite(CommunityDTO communityDTO);	
	// 행 삭제
	public int communityDelete(int seq, String user_pwd);	
	// 내용 수정
	public int communityModify(CommunityDTO communityDTO);	
	// 목록 확인 : 전체 
	public List<CommunityDTO> communityList();
	// 목록 확인 : 페이징 처리
	public List<CommunityDTO> communityIndexList(int startNum, int endNum);
	// 상세보기 : 행 한개 내용보기
	public CommunityDTO communitySelect(int seq);
	
	
	public int getCommunityFirstSeq();
	
	public int filesWrite(FilesDTO filesDTO);
	
	public String checkFiles(int community_seq);
	
	public int filesDelete(int community_seq, String filePath);
}




