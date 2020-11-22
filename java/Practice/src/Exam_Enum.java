
enum Season {					// class 외부에서 선언 (똑같음)
	봄, 여름, 가을, 겨울
}

public class Exam_Enum {
	public enum Season{			// class 내부에서 선언
		봄, 여름, 가을, 겨울
	}
	
	public String name;
	public Season favorite_session;
	
	public static void main(String[] args) {
		Season season = Season.봄;
		System.out.println(season);
		System.out.println(Season.여름);
		System.out.println();
		
		Exam_Enum people = new Exam_Enum();
		people.name = "홍길동";
		people.favorite_session = Season.봄;
		System.out.println("이름 : " + people.name);
		System.out.println("좋아하는 계절 : " + people.favorite_session);
		System.out.println();
		
		for(Season sea : Season.values()){
    	    System.out.println(sea);
        }
		System.out.println();
		
		// 전체 열거 객체 중 몇번째 열거 객체인지 알려준다. (0부터 시작)
		Season seson = Season.여름;
    	System.out.println(seson.ordinal());
	}
}

