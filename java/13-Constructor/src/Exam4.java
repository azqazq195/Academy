import aaa.Member;

public class Exam4 {
	public static void main(String[] args) {
		Member member = new Member("홍길동", 25);
		System.out.println(member.getName());
		System.out.println(member.getAge());
		
		member.setName("고길동");
		member.setAge(30);
		System.out.println(member.getName());
		System.out.println(member.getAge());
	}
}
