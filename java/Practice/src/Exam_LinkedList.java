import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Exam_LinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();   //Ÿ�� �̼��� Object�� ����ȴ�.
		list = new LinkedList<Integer>();                       //Ÿ�Լ��� intŸ�Ը� ��밡��
		list = new LinkedList<>();                              //new���� Ÿ�� �Ķ���� ��������
		list = new LinkedList<Integer>(Arrays.asList(1,2));     //������ ���߰�
		
		list = new LinkedList<Integer>();
		list.add(3);											//������ �߰�
		list.addFirst(1);										//���� �տ� ������ �߰�
		list.addLast(2);										//���� �ڿ� ������ �߰�
		list.add(1, 10);										//index 1�ڿ� ������ 10 �߰�
		System.out.println(list.toString());
		
		list = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
		list.removeFirst();            							//���� ���� ������ ����
		list.removeLast();              						//���� ���� ������ ����
		list.remove();                  						//������ 0��° index����
		list.remove(1);                 						//index 1 ����
		list.clear();                   						//��� �� ����
		System.out.println(list.toString());
		
		System.out.println();
		System.out.println("size");
		list = new LinkedList<Integer>(Arrays.asList(1,2,3));
		System.out.println(list.size()); //list ũ�� : 3
				
		System.out.println();
		list = new LinkedList<Integer>(Arrays.asList(1,2,3));
		System.out.println(list.get(0));              //0��° index ���
		System.out.println("for");
		for(Integer i : list) {                       //for���� ���� ��ü���
		    System.out.println(i);
		}
		System.out.println("Iterator");
		Iterator<Integer> iter = list.iterator();     //Iterator ���� 
		while(iter.hasNext()){                        //�������� �ִ��� üũ
		    System.out.println(iter.next());          //�� ���
		}
		
		System.out.println();
		System.out.println("�˻�");
		list = new LinkedList<Integer>(Arrays.asList(1,2,3));
		System.out.println(list.contains(1));             //list�� 1�� �ִ��� �˻� : true
		System.out.println(list.indexOf(1));    
	}
}
