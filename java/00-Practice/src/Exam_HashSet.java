import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Exam_HashSet {
	public static void main(String[] args) {
		HashSet<Integer> set1;
		set1 = new HashSet<Integer>();			// HashSet ����
		set1 = new HashSet<>();					// new���� Ÿ�� �Ķ���� ���� ����
		set1 = new HashSet<Integer>(set1);		// set1�� ��� ���� ���� HashSet ����
		set1 = new HashSet<Integer>(10);		// �ʱ� �뷮(capacity)����
		set1 = new HashSet<Integer>(10, 0.7f);	// �ʱ� (capacity, load factor)����
		set1 = new HashSet<Integer>(Arrays.asList(1,2,3));	// �ʱⰪ ����

		// HashSet �� �߰�
		HashSet<Integer> set = new HashSet<Integer>();		// HashSet ����
		set.add(1);			// �� �߰� ����
		set.add(2);
		set.add(3);
		set.add(3);			// 1, 2, 3(�ߺ�����)
		System.out.println(set);
		System.out.println();
		
		// HashSet �� ����
		set = new HashSet<Integer>(Arrays.asList(1,2,3));	// HashSet ����
		System.out.println(set);
		System.out.println();
		
		set.remove(1);		// �� 1 ����
		System.out.println(set);
		System.out.println();
		
		set.clear(); 		// ��� �� ����
		System.out.println(set);
		System.out.println();
		
		// HashSet ũ�� ���ϱ�
		set = new HashSet<Integer>(Arrays.asList(1,2,3));	// HashSet ����
		System.out.println("size : " + set.size());
		System.out.println();
		
		// �� ���
		System.out.println(set);
		System.out.println();
		
		Iterator<Integer> iter = set.iterator();			// iterator ���
		while(iter.hasNext()) {								// ���� ������ true ������ false
			System.out.println(iter.next());
		}
		System.out.println();
		
		// HashSet �� �˻�
		System.out.println(set.contains(1));
	}
}
