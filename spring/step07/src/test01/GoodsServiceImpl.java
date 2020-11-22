package test01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	GoodsDAOSpring goodsDAOSpring;

	@Override
	public int insertGoods(GoodsVO vo) {
		return goodsDAOSpring.insertGoods(vo);
	}
	@Override
	public int delesteGoods(GoodsVO vo) {
		return goodsDAOSpring.delesteGoods(vo);
	}
	@Override
	public GoodsVO getGoods(GoodsVO vo) {
		return goodsDAOSpring.getGoods(vo);
	}
	@Override
	public List<GoodsVO> getGoodsList() {
		return goodsDAOSpring.getGoodsList();
	}

}
