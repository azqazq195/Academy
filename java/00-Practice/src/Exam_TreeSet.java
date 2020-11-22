import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class Exam_TreeSet {
	public static void main(String[] args) {
		TreeSet<Integer> set1;
		set1 = new TreeSet<Integer>();						// TreeSet ����
		set1 = new TreeSet<>();								// new���� Ÿ�� �Ķ���� ���� ����
		set1 = new TreeSet<Integer>(set1);					// set1�� ��� ���� ���� TreeSet ����
		set1 = new TreeSet<Integer>(Arrays.asList(1,2,3));	// �ʱⰪ ����
		
		// TreeSet �� �߰�
		System.out.println("TreeSet �� �߰�");
		TreeSet<Integer> set = new TreeSet<Integer>();		// TreeSet ����
		set.add(7);											// �� �߰�
		set.add(4);
		set.add(9);
		set.add(1);
		set.add(5);
		System.out.println(set);
		System.out.println();
		
		// TreeSet �� ����
		System.out.println("TreeSet �� ����");
		set = new TreeSet<Integer>(Arrays.asList(7,4,9,1,5));
		set.remove(4);	// �� ����
		System.out.println(set);
		set.clear();	// ��� �� ����
		System.out.println(set);
		System.out.println();
		
		// TreeSet ũ�� ���ϱ�
		System.out.println("TreeSet ũ�� ���ϱ�");
		set = new TreeSet<Integer>(Arrays.asList(7,4,9,1,5));
		System.out.println("size : " + set.size());
		System.out.println();
		
		// TreeSet �� ���
		set = new TreeSet<Integer>(Arrays.asList(7,4,9,1,5));
		System.out.println("All : " + set);							// ��ü ���
		System.out.println("�ּڰ� : " + set.first());				// �ּҰ� ���
		System.out.println("�ִ� : " + set.last());					// �ִ밪 ���
		System.out.println();
		System.out.println("��ū�� : " + set.last());					// �ִ밪 ���
		System.out.println("�ι�° ū�� : " + set.lower(set.last()));
		// �Է°����� ū ������ �� �ּڰ� ���, ������ null
		System.out.println("3���� ū �� : " + set.higher(3));
		// �Է°����� ���� ������ �� �ִ� ���, ������ null
		System.out.println("3���� ���� �� : " + set.lower(3));
		set.add(20);
		set.add(-1);
		System.out.println();
		
		Iterator<Integer> iter = set.descendingIterator();			// Iterator ���
		while(iter.hasNext()) {										// ���� ������ true ������ false
			System.out.println(iter.next());
		}
	}
}
