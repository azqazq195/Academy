
public class Exam1 {
	public static void main(String[] args) {
		short s = 100;
		int i = s;
		long l = i;
		float f = l;
		double d = f;
		System.out.println("s = " + s);
		System.out.println("i = " + i);
		System.out.println("l = " + l);
		System.out.println("f = " + f);
		System.out.println("d = " + d);
		System.out.println("-------------");
		
		d = 3.14;
		f = (float)d;
		l = (long)f;
		i = (int)l;
		s = (short)i;
		System.out.println("s = " + s);
		System.out.println("i = " + i);
		System.out.println("l = " + l);
		System.out.println("f = " + f);
		System.out.println("d = " + d);
		System.out.println("-------------");
		
		char ch = 'a';
		int num = ch;
		System.out.println("num = " + num);		
		num = 65;
		ch = (char)num;
		System.out.println("ch = " + ch);	
		System.out.println("-------------");
		int aa = 130;
		byte bb = 127;   // byte : 1byte 정수 저장, -128~+127
		System.out.println(bb);
		bb++;
		System.out.println(bb);
		bb = (byte)aa;
		System.out.println(bb);
	}
}





