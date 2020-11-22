
public class Test2 extends Sales{
	private int amount;  // 총액
	// 총액을 계산해서 amount에 저장
	void setPorcess() {
		amount = getQty() * getCost();
	}
	void getDisplay() {
		// 판매가격 = 총액 - 총액*할인율
		int resultSales = (int)(amount - amount * Sales.getDiscount());
		System.out.println(getArticle() + "\t" + resultSales);
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}	
}
