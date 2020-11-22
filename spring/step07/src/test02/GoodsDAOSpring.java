package test02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	// SQL 명령어
	String goods_insert = "insert into goods values (?, ?, ?, ?)";
	String goods_delete = "delete goods where code=?";
	String goods_get = "select * from goods where code=?";
	String goods_list = "select * from goods";
	
	/** CRUD 기능의 메소드 **/
	// 책 등록
	int insertGoods(GoodsVO vo) {
		// 방법1
		//int result = jdbcTemplate.update(goods_insert, vo.getCode(), vo.getName(),
		//						vo.getPrice(), vo.getMaker());
		
		// 방법2
		Object[] args = {vo.getCode(), vo.getName(), vo.getPrice(), vo.getMaker()};
		int result = jdbcTemplate.update(goods_insert, args);
		return result;
	}
	// 책 삭제
	int delesteGoods(GoodsVO vo){
		int result = jdbcTemplate.update(goods_delete, vo.getCode());
		return result;
	}
	// 책 상세 조회
	GoodsVO getGoods(GoodsVO vo){
		Object[] args = {vo.getCode()};
		return jdbcTemplate.queryForObject(goods_get, args, new GoodsRowMapper());
	}
	// 책 목록 조회
	List<GoodsVO> getGoodsList(){
		return jdbcTemplate.query(goods_list, new GoodsRowMapper());
	}
}







