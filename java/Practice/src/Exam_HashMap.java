import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Exam_HashMap {
	public static void main(String[] args) {
		HashMap<String, String> map1;
		map1 = new HashMap<String, String>();		// HashMap ����
		map1 = new HashMap<>();						// new���� Ÿ�� �Ķ���� ���� ����
		map1 = new HashMap<>(map1);					// map1�� ��� ���� ���� HashMap ����
		map1 = new HashMap<>(10);					// �ʱ� �뷮(capacity) ����
		map1 = new HashMap<>(10, 0.7f);				// �ʱ� capacity, load factor ����
		map1 = new HashMap<String, String>(){{		// �ʱⰪ ����
			put("a","b");
		}};
		System.out.println(map1);
		
		// HashMap �� �߰�
		HashMap<Integer, String> map = new HashMap<>();	// new���� Ÿ�� �Ķ���� ���� ����
		map.put(1, "���");	// �� �߰�
		map.put(2, "�ٳ���");
		map.put(3, "����");
		System.out.println(map);
		System.out.println();
		
		// HashMap �� ����
		map = new HashMap<Integer, String>(){{			//�ʱⰪ ����
		    put(1,"���");
		    put(2,"�ٳ���");
		    put(3,"����");
		}};
		System.out.println(map);
		map.remove(1); 	//key�� 1 ����
		System.out.println(map);
		map.clear(); 	//��� �� ����
		System.out.println(map);
		System.out.println();
		
		// �� ���
		map = new HashMap<Integer, String>(){{			//�ʱⰪ ����
		    put(1,"���");
		    put(2,"�ٳ���");
		    put(3,"����");
		}};
		System.out.println(map);			// ��ü ���
		System.out.println(map.get(1));		// key�� 1�� value ���
		
		// enrtySet() Ȱ��
		for(Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("[key] : " + entry.getKey()
			+ " [Value] : " + entry.getValue()
			);
		}
		
		// keySet() Ȱ��
		for(Integer i : map.keySet()) {
			System.out.println("[key] : " + i
			+ " [Value] : " + map.get(i)
			);
		}
		System.out.println();
		
		// Iterator ���
		map = new HashMap<Integer, String>(){{			//�ʱⰪ ����
		    put(1,"���");
		    put(2,"�ٳ���");
		    put(3,"����");
		}};
		
		// entrySet().iterator()
		Iterator<Entry<Integer, String>> entries = map.entrySet().iterator();
		while(entries.hasNext()) {
			Map.Entry<Integer, String> entry = entries.next();
			System.out.println("[key] : " + entry.getKey()
			+ " [Value] : " + entry.getValue()
			);
		}
		
		// keySet().iterator()
		Iterator<Integer> keys = map.keySet().iterator();
		while(keys.hasNext()){
		    int key = keys.next();
		    System.out.println("[Key]:" + key + " [Value]:" +  map.get(key));
		}
	}
}
