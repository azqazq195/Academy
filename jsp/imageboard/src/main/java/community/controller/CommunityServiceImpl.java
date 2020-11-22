package community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import community.bean.CommunityDTO;
import community.dao.CommunityDAO;
import files.bean.FilesDTO;
import files.dao.FilesDAO;

@Service
public class CommunityServiceImpl implements CommunityService{
	@Autowired
	CommunityDAO communityDAO;
	@Autowired	
	FilesDAO filesDAO;

	@Override
	public int communityWrite(CommunityDTO communityDTO) {
		return communityDAO.communityWrite(communityDTO);
	}
	@Override
	public int communityDelete(int seq, String user_pwd) {
		return communityDAO.communityDelete(seq, user_pwd);
	}
	@Override
	public int communityModify(CommunityDTO communityDTO) {
		return communityDAO.communityModify(communityDTO);
	}
	@Override
	public List<CommunityDTO> communityList() {
		return communityDAO.communityList();
	}
	@Override
	public List<CommunityDTO> communityIndexList(int startNum, int endNum) {
		return communityDAO.communityIndexList(startNum, endNum);
	}
	@Override
	public CommunityDTO communitySelect(int seq) {
		return communityDAO.communitySelect(seq);
	}
	
	@Override
	public int getCommunityFirstSeq() {
		return filesDAO.getCommunityFirstSeq();
	}
	@Override
	public int filesWrite(FilesDTO filesDTO) {
		return filesDAO.filesWrite(filesDTO);
	}
	@Override
	public String checkFiles(int community_seq) {
		return filesDAO.checkFiles(community_seq);
	}
	@Override
	public int filesDelete(int community_seq, String filePath) {
		return filesDAO.filesDelete(community_seq, filePath);
	}
}




