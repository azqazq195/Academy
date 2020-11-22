package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.bean.GoodsVO;
import test.dao.GoodsDAO;

/*
 * <bean id="goodsService" class="test.service.GoodsServiceImpl">
 * 		<property name="goodsDAO" ref="goodsDAO">
 * </bean> 
 */
// @Component와 같은 어노테이션
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{	
	@Autowired
	private GoodsDAO goodsDAO;

	@Override
	public int insertGoods(GoodsVO vo) {
		return goodsDAO.insertGoods(vo);
	}

	@Override
	public List<GoodsVO> getGoodsList() {
		return goodsDAO.getGoodsList();
	}
}





