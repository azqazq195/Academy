package aop03;

import org.aspectj.lang.JoinPoint;

// 공통 관심 사항을 모아논 클래스
public class MyAspect {
	public void before(JoinPoint joinPoint) {
		System.out.println("교실문을 연다.");
	}
	
	public void after(JoinPoint joinPoint) {
		System.out.println("교실문을 닫는다.");
	}
}
