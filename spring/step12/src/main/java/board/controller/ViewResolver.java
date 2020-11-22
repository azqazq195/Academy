package board.controller;
// 접두사 + 파일이름 + 접미사
// "../board/" + "boardList" + ".jsp"
// => ../board/boardList.jsp
public class ViewResolver {
	private String prefix;	// 접두사
	private String suffix;	// 접미사 
	
	public String getView(String viewName) {
		// 접두사 + 파일이름 + 접미사
		return prefix + viewName + suffix;
	}
	
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}	
}
