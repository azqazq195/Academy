package test02;

import java.util.List;

public interface GoodsService {
	/** CRUD 기능의 메소드
	 *  => Service 클래스의 역할은 여러 DAO 클래스를 통합 관리하는 것임 
	 **/
	// 책 등록
	int insertGoods(GoodsVO vo);
	// 책 삭제
	int delesteGoods(GoodsVO vo);
	// 책 상세 조회
	GoodsVO getGoods(GoodsVO vo);
	// 책 목록 조회
	List<GoodsVO> getGoodsList();
}







