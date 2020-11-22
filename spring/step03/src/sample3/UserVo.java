package sample3;

public class UserVo {
	private String userName;

	public UserVo(String userName) {
		super();
		this.userName = userName;
		System.out.println("UserVo(String userName) 호출");
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
