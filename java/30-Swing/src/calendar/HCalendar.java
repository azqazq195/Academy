package calendar;

import java.util.Calendar;
import javax.swing.JButton;

//날짜 계산
public class HCalendar {
	JButton[] buttons;
	Calendar calendar;
	int year, month;
	
	public HCalendar() {
		calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
	}
	
	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}
	// label에 출력할 년월 문자열
	public String getCalText() {
		return year + "년 " + month + "월"; 
	}
	// 달력을 새로운 년월로 새로 그리기
	public void allInit(int gap) {
		// 버튼의 날짜 지우기
		for(int i=7; i<buttons.length; i++) {
			buttons[i].setText("");
		}
		// 년/월 수정
		calInput(gap);
		// 버튼에 날짜 출력
		calSet();
	}
	// 년월 수정
	public void calInput(int gap) {
		month += gap;
		if(month <= 0) { 		 // 작년으로 바뀜
			year--;
			month = 12;
		} else if(month >= 13) { // 내년으로 바뀜
			year++;
			month = 1;
		}
	}
	// 버튼에 날짜 출력하기
	// 1) 그달의 1일의 요일
	// 2) 그달의 총일수	
	public void calSet() {
		// Calendar 클래스의 년, 월, 일 수정
		calendar.set(year, month-1, 1);
		// 그달의 1일이 시작되는 요일수 (일~토 : 1~7)
		// 버튼의 배열은 위치값시작은 0부터 시작함
		int firstDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;  // 요일수 - 1
		for(int i=1; i<=calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			// buttons[0]~[6] : 일~토
			buttons[6+firstDay+i].setText(String.valueOf(i));
		}
		
	}
}












