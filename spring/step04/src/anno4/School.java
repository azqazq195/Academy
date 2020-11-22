package anno4;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class School {
	// @Autowired는 주입시킬 bean 객체를 찾을 때, 
	// 1. 자료형이 한개인 멤버변수는 똑 같은 자료형을 찾음  
	// 2. 같은 자료형의 멤버변수가 여러개인 경우에는 이름이 같은 것을 찾음
	@Autowired
	@Qualifier("student")
	public Student person;
	/*
	@Resource(name="grade1")
	=>
	@Autowired
	@Qualifier("grade1")
	두개를 결합한 어노테이션
	*/
	@Resource(name="grade1")
	public int grade;
	
	@Override
	public String toString() {
		return "School [person=" + person + ", grade=" + grade + "]";
	}

	public Student getPerson() {
		return person;
	}
	public void setPerson(Student person) {
		this.person = person;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
