package board.bean;

// 목록 처리시 사용할 변수를 묶어서 관리
public class PageInfo {
	private int page;		// 현재 페이지
	private int startPage;	// 시작 페이지
	private int endPage;	// 끝 페이지
	private int maxPage;	// 총 페이지 수
	private int listCount;	// 총목록수
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}	
}
