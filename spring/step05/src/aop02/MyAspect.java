package aop02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
// aop를 이용하면, 공통관심사항 동작이 필요한 함수를 호출할 경우,
// 스프링 컨테이터는 그 함수를 가로채서 invoke 함수를 호출하고 
// 매개변수로 가로챈 함수가 전달한다.
public class MyAspect  implements MethodInterceptor{
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object returnValue = null;   // 모든 자료형에 대한 리턴값을 저장
		
		// 대상 메소드 실행전 코드
		System.out.println("교실문을 연다");
		
		try {
			// 대상 메소드를 실행
			returnValue = invocation.proceed();
		} catch (Exception e) {
			// 대상 메소드 실행중 예외 발생시 실행되는 코드
			System.out.println("** 오늘은 소독하는 날 **");
		} finally {
			// 대상 메소드 실행 후 코드
			System.out.println("전등이 켜져 있는 지 확인한다.");
		}
		
		// 대상 메소드 실행후 코드
		System.out.println("교실문을 잠근다.");
		
		return returnValue;
	}
}
