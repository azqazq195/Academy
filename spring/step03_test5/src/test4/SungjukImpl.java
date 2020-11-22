package test4;

import java.util.Scanner;

public class SungjukImpl implements Sungjuk{

	SungjukDTO sungjukDTO;	
	
	// 우리가 생성자 1개도 만들지 않으면, 디폴트 생성자가 제공되어지고
	// 우리가 생성자를 1개라도 만들면, 디폴트 생성자는 제공되지않음
	public SungjukImpl() {
		super();
	}
	public SungjukImpl(SungjukDTO sungjukDTO) {
		super();
		this.sungjukDTO = sungjukDTO;
	}	

	public SungjukDTO getSungjukDTO() {
		return sungjukDTO;
	}
	public void setSungjukDTO(SungjukDTO sungjukDTO) {
		this.sungjukDTO = sungjukDTO;
	}

	@Override
	public void calcTot() {
		int tot = sungjukDTO.getEng() + sungjukDTO.getKor() + sungjukDTO.getMat();
		sungjukDTO.setTot(tot);
	}

	@Override
	public void calcAvg() {
		sungjukDTO.setAvg((double)sungjukDTO.getTot() / 3);
	}

	@Override
	public void display() {
		System.out.printf("%10s %10s %10s %10s %10s %10s", "이름", "국어", "영어", "수학", "총점", "평균");
		System.out.println();
		System.out.printf("%10s %10d %10d %10d %10d %10.1f", sungjukDTO.getName(), sungjukDTO.getKor(), 
				sungjukDTO.getEng(), sungjukDTO.getMat(), sungjukDTO.getTot(), sungjukDTO.getAvg());
	}

	@Override
	public void modify() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println();
		System.out.print("이름 입력 : ");
		sungjukDTO.setName(sc.next());
		System.out.print("국어 입력 : ");
		sungjukDTO.setKor(sc.nextInt());
		System.out.print("영어 입력 : ");
		sungjukDTO.setEng(sc.nextInt());
		System.out.print("수학 입력 : ");
		sungjukDTO.setMat(sc.nextInt());
		
		calcTot();
		calcAvg();
	}

}
