package aop07;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

// 공통 관심사항을 모아둔 클래스
public class LoggingAdvice {
	// 매개변수로 호출을 가로챈 함수가 전달됨
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		/** 핵심 관심사항 동작전에 실행할 코드 **/
		// 호출을 가로챈 함수의 이름을 얻어오기
		String methodName = joinPoint.getSignature().getName();
		StopWatch sw = new StopWatch();
	
		System.out.println("From [bean.xml]");
		System.out.println("[LOG]METHOD : " + methodName + " is Calling\n");
		sw.start();
		
		// 핵심 관심사항
		joinPoint.proceed();
		
		/** 핵심 관심사항 동작후에 실행할 코드 **/
		sw.stop();
		
		System.out.println("[LOG]METHOD : " + methodName + " was done...");
		System.out.println("[LOG]처리시간 : " + sw.getTotalTimeMillis() + "ms");
	}
}



