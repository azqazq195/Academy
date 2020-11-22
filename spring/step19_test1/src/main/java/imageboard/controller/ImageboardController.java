package imageboard.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageboardDAO;

@Controller
public class ImageboardController {
	@RequestMapping(value = "/imageboard/imageboardWriteForm")
	public String imageboardWriteForm() {
		return "imageboardWriteForm";
	}
	
	// MultipartFile img : 변수명 img는 <input type="file" name="img"> 태그의 name과 일치해야 한다.
	@RequestMapping(value = "/imageboard/imageboardWrite")
	public ModelAndView imageboardWrite(HttpServletRequest request, MultipartFile img) {		
		String filePath = 
			"D:\\android_ycs\\spring\\workspace\\step19\\src\\main\\webapp\\storage";
		String fileName = img.getOriginalFilename();
		File file = new File(filePath, fileName);
		
		// 파일 복사
		// => getInputStream() : 업로드한 파일 데이터를 읽어오는 InputStream을 구한다.
		try {
			FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ImageboardDTO dto = new ImageboardDTO();
		dto.setImageId(request.getParameter("imageId"));
		dto.setImageName(request.getParameter("imageName"));
		dto.setImagePrice(Integer.parseInt(request.getParameter("imagePrice")));
		dto.setImageQty(Integer.parseInt(request.getParameter("imageQty")));
		dto.setImageContent(request.getParameter("imageContent"));
		dto.setImage1(fileName);
		
		// DB
		ImageboardDAO imageboardDAO = new ImageboardDAO();
		int su = imageboardDAO.imageboardWrite(dto);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", dto);
		modelAndView.addObject("su", su);
		modelAndView.setViewName("imageboardWrite");
		return modelAndView;
	}
	
	@RequestMapping(value = "/imageboard/imageboardDelete")
	public ModelAndView imageboardDelete(HttpServletRequest request) {
		// 데이터 
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// DB
		ImageboardDAO imageboardDAO = new ImageboardDAO();
		int su = imageboardDAO.imageboardDelete(seq);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("imageboardDelete");
		return modelAndView;
	}
	
	@RequestMapping(value = "/imageboard/imageboardList")
	public ModelAndView imageboardList(HttpServletRequest request) {
		// 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// DB
		// 목록 : 5개씩		
		int endNum = pg * 5;
		int startNum = endNum - 4;
		ImageboardDAO imageboardDAO = new ImageboardDAO();
		List<ImageboardDTO> list = imageboardDAO.imageboardList(startNum, endNum);
		
		// 페이징 : 3블럭
		int totalA = imageboardDAO.getTotalA(); 	// 총 데이터 갯수
		int totalP = (totalA + 4) / 5;				// 총 페이지 수
		int startPage = (pg -1)/3*3 + 1;
		int endPage = startPage + 2;
		if(endPage > totalP) endPage = totalP;
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list); 
		modelAndView.addObject("totalP", totalP); 
		modelAndView.addObject("startPage", startPage); 
		modelAndView.addObject("endPage", endPage); 
		modelAndView.setViewName("imageboardList");
		return modelAndView;
	}
	
	@RequestMapping(value = "/imageboard/imageboardView")
	public ModelAndView imageboardView(HttpServletRequest request) {
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// DB
		ImageboardDAO imageboardDAO = new ImageboardDAO();
		ImageboardDTO imageboardDTO = imageboardDAO.imageboardView(seq);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("imageboardDTO", imageboardDTO);
		modelAndView.setViewName("imageboardView");
		return modelAndView;
	}
}












