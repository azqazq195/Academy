
enum Season {					// class �ܺο��� ���� (�Ȱ���)
	��, ����, ����, �ܿ�
}

public class Exam_Enum {
	public enum Season{			// class ���ο��� ����
		��, ����, ����, �ܿ�
	}
	
	public String name;
	public Season favorite_session;
	
	public static void main(String[] args) {
		Season season = Season.��;
		System.out.println(season);
		System.out.println(Season.����);
		System.out.println();
		
		Exam_Enum people = new Exam_Enum();
		people.name = "ȫ�浿";
		people.favorite_session = Season.��;
		System.out.println("�̸� : " + people.name);
		System.out.println("�����ϴ� ���� : " + people.favorite_session);
		System.out.println();
		
		for(Season sea : Season.values()){
    	    System.out.println(sea);
        }
		System.out.println();
		
		// ��ü ���� ��ü �� ���° ���� ��ü���� �˷��ش�. (0���� ����)
		Season seson = Season.����;
    	System.out.println(seson.ordinal());
	}
}

