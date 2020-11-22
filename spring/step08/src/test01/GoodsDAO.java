package test01;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class GoodsDAO {
	private SqlSession sqlSession;
	
	public GoodsDAO() {
		sqlSession = SqlMapClientFactory.getSqlMapClientInstance();
	}
	
	/** CRUD 기능의 메소드 구현 **/
	// 책 등록
	public int insertGoods(GoodsVO vo) {
		return sqlSession.insert("mybatis.goodsMapper.insertGoods", vo);
	}	
	// 책 삭제
	public int deleteGoods(GoodsVO vo) {
		return sqlSession.delete("mybatis.goodsMapper.deleteGoods", vo);
	}	
	// 책 목록 조회
	public List<GoodsVO> getGoodsList() {
		return sqlSession.selectList("mybatis.goodsMapper.getGoodsList");
	}	
	// 책 상세 조회	
	public GoodsVO getGoods(GoodsVO vo) {
		return sqlSession.selectOne("mybatis.goodsMapper.getGoods", vo);
	}
}












