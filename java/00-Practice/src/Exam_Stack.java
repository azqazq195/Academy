import java.util.Stack;

public class Exam_Stack {
	public static void main(String[] args) {
		// ���� ����
		Stack<Integer> stack = new Stack<Integer>();
		
		// ������ �Է�
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		// ������ Ȯ��(���� ���� ����)
		System.out.println(stack.peek());
		System.out.println();
		
		// ���� ������ Ȯ��
		System.out.println(stack.size());
		System.out.println();
		
		// ������ ������ ������
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println();
			
	}
}
