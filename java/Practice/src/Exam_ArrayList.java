import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Exam_ArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list = new ArrayList<Integer>();                                 //Ÿ�Լ��� intŸ�Ը� ��밡��
		list = new ArrayList<>();                                       //new���� Ÿ�� �Ķ���� ��������
		list = new ArrayList<Integer>(10);                              //�ʱ� �뷮(capacity)����
		list = new ArrayList<Integer>(Arrays.asList(1,2,3));           //������ ���߰�
		
		
		list = new ArrayList<Integer>();
		list.add(3);                        					//�� �߰�
		list.add(null);                     					//null���� add����
		list.add(1,10);                     					//index 1�ڿ� 10 ����

		
		list = new ArrayList<Integer>(Arrays.asList(1,2,3));
		list.remove(1);                            				//index 1 ����
		list.clear();                              				//��� �� ����
		
		list = new ArrayList<Integer>(Arrays.asList(1,2,3));
		System.out.println("size");
		System.out.println(list.size());                		//list ũ�� : 3
		
		
		list = new ArrayList<Integer>(Arrays.asList(1,2,3));
		System.out.println("0��° �ε���");
		System.out.println(list.get(0));               			//0��° index ���
				
		System.out.println("for");
		for(Integer i : list) {                        			//for���� ���� ��ü���
		    System.out.println(i);
		}

		System.out.println("Iterator");
		Iterator<Integer> iter = list.iterator();               //Iterator ���� 
		while(iter.hasNext()){                         			//�������� �ִ��� üũ
		    System.out.println(iter.next());           			//�� ���
		}
		
		System.out.println("�˻�");
		list = new ArrayList<Integer>(Arrays.asList(1,2,3));
		System.out.println(list.contains(1));                         //list�� 1�� �ִ��� �˻� : true
		System.out.println(list.indexOf(1));                          //1�� �ִ� index��ȯ ������ -1
		
	}
}
