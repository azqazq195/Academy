package test02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class GoodsServiceImpl implements GoodsService{	
	private GoodsDAO goodsDAO;	

	public GoodsDAO getGoodsDAO() {
		return goodsDAO;
	}
	public void setGoodsDAO(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}
	
	@Override
	public int insertGoods(GoodsVO vo) {
		return goodsDAO.insertGoods(vo);
	}
	@Override
	public int delesteGoods(GoodsVO vo) {
		return goodsDAO.deleteGoods(vo);
	}
	@Override
	public List<GoodsVO> getGoodsList() {
		return goodsDAO.getGoodsList();
	}
	@Override
	public GoodsVO getGoods(GoodsVO vo) {
		return goodsDAO.getGoods(vo);
	}
}





