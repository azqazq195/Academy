package community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import community.bean.CommunityDTO;
import community.dao.CommunityDAO;

@Service
public class CommunityServiceImpl implements CommunityService{
	@Autowired
	CommunityDAO communityDAO;

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

}




