import java.util.Stack;

public class Exam_Stack {
	public static void main(String[] args) {
		// 스택 생성
		Stack<Integer> stack = new Stack<Integer>();
		
		// 데이터 입력
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		// 데이터 확인(삭제 하지 않음)
		System.out.println(stack.peek());
		System.out.println();
		
		// 스택 사이즈 확인
		System.out.println(stack.size());
		System.out.println();
		
		// 마지막 데이터 꺼내기
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println();
			
	}
}
