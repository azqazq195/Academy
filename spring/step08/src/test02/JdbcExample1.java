package test02;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcExample1 {
	public static void main(String[] args) {
		// 1. spring 컨테이너 구공
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("bean2.xml");
		
		// 2. service 얻어오기
		GoodsService goodsService = (GoodsService) context.getBean("goodsService");
		/*
		// 2. dao 얻어오기
		GoodsDAO goodsDAO = (GoodsDAO) context.getBean("goodsDAO");
		*/
		
		// 3. 책 등록
		GoodsVO vo = new GoodsVO();
		vo.setCode("p0001");
		vo.setName("Java");
		vo.setPrice(20000);
		vo.setMaker("한샘출판사");
		
		int result = goodsService.insertGoods(vo);
		if(result > 0) {
			System.out.println("저장 성공");
		} else {
			System.out.println("저장 실패");
		}
		// 4. 책 목록
		List<GoodsVO> list = goodsService.getGoodsList();
		for(GoodsVO vo1 : list) {
			System.out.println("---> " + vo1.toString());
		}
		
		// 5. 스프링 컨테이너 종료
		context.close();
	}
}







