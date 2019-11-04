package kr.or.ddit.basic;

public class T03_GenericTest2 {

	public static void main(String[] args) {
		Generic<String> gen = new Generic<String>();
		Generic<Integer> gen2 = new Generic<Integer>();
		
		gen.setName("박신규");
		gen2.setPhonenum(123);
		
		String a = gen.getName();
		int b = gen2.getPhonenum();
		
		System.out.println(a);
		System.out.println(b);
	}
}

class Generic<T>{
	private T name;
	private T phonenum;
	public T getName() {
		return name;
	}
	public void setName(T name) {
		this.name = name;
	}
	public T getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(T phonenum) {
		this.phonenum = phonenum;
	}
	
}