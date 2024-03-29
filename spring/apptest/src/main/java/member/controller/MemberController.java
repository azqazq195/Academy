package member.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import files.bean.FilesDTO;
import member.bean.MemberDTO;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/member/member_insert.do")
	public ModelAndView memberWrite(HttpServletRequest request, MultipartFile photo) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String dir = request.getSession().getServletContext().getRealPath("/storage");
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName(name);
		memberDTO.setPhone(phone);
		memberDTO.setEmail(email);
		memberDTO.setAddr(addr);
		
		int result1 = memberService.memberWrite(memberDTO);
		
		int member_seq = 0;
	    String rt = "FAIL";   
	    if(result1 > 0) rt = "OK";
	      
	      // 글 데이터 저장이 성공한 경우, 파일 관련 데이터 저장
	      if(rt.equals("OK")) {
	         // photo는 파일이 전달되지 않으면 null
	         if(photo != null) {
	            // 전송되어온 파일 이름
	            String originname = photo.getOriginalFilename();
	            // storage 폴더에 저장된 파일 이름
	            String filename = photo.getOriginalFilename();
	            // 저장할 파일의 확장자를 원본이름에서 추출
	            int lastIndex = originname.lastIndexOf(".");
	            String filetype = originname.substring(lastIndex + 1);
	            // 파일의 크기
	            int filesize = (int)photo.getSize();
	            // 파일 복사
	            File file = new File(dir, filename);
	            FileCopyUtils.copy(photo.getInputStream(), new FileOutputStream(file));
	            
	            // dto에 저장
	            FilesDTO filesDTO = new FilesDTO();
	            filesDTO.setDir(dir);
	            filesDTO.setOriginname(originname);
	            filesDTO.setFilename(filename);
	            filesDTO.setFiletype(filetype);
	            filesDTO.setFilesize(filesize);
	            
	            // community seq 값 얻기
	            member_seq = memberService.getMemberFirstSeq();
	            filesDTO.setMember_seq(member_seq);
	            
	            int result2 = memberService.filesWrite(filesDTO);
	         }      
	      }
		
		
		JSONObject json = new JSONObject();
	    json.put("rt", rt);
	    json.put("seq", member_seq);
	    
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("json", json);
	    modelAndView.setViewName("member.jsp");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "/member/member_list.do")
	public ModelAndView memberList(HttpServletRequest request) throws Exception {
		System.out.println("member_list.do 로드");
		List<MemberDTO> list = memberService.memberList();
		
		int total = list.size();
		String rt = "FAIL";
		if(total != 0){
			rt = "OK";
		}
		
		//json 출력
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		json.put("total", total);
		JSONArray array = new JSONArray();
		
		for(MemberDTO memberDTO : list){
			JSONObject temp = new JSONObject();
			int id = memberDTO.getId();
			String filename = memberService.checkFiles(id);
			String fileURL = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + request.getContextPath()
				+ "/storage/" + filename;
			temp.put("id",id);
			temp.put("name",memberDTO.getName());
			temp.put("phone",memberDTO.getPhone());
			temp.put("email",memberDTO.getEmail());
			temp.put("addr",memberDTO.getAddr());
			temp.put("logtime",memberDTO.getLogtime());
			
			if(memberService.checkFiles(id) != null){
				temp.put("filename", fileURL);
			} else {
				temp.put("filename", "");
			}
			array.put(temp);
		}
		
		json.put("item", array);
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("member.jsp");
		return modelAndView;
	}
}
