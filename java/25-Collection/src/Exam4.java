import java.util.ArrayList;
import java.util.List;

import study.java.model.People;

public class Exam4 {
	public static void main(String[] args) {
		// List에 데이터를 저장할 때는 java beans클래스를 주로 저장함
		List<People> list = new ArrayList<People>();
		
		People p1 = new People("홍길동", "010-1234-5678");
		list.add(p1);
		People p2 = new People("김철수", "010-1234-5677");
		list.add(p2);
		People p3 = new People("이영희", "010-1234-5676");
		list.add(p3);
		People p4 = new People("고길동", "010-1234-5675");
		list.add(p4);
		People p5 = new People("김길동", "010-1234-5674");
		list.add(p5);
		
		for(int i=0; i<list.size(); i++) {
			People tmp = list.get(i);
			System.out.println(tmp.toString());
		}
	}
}
