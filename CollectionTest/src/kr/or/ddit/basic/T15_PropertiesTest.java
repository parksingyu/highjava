package kr.or.ddit.basic;

import java.util.Properties;

public class T15_PropertiesTest {
/*
	Properties는 Map보다 축소된 기능의 객체라고 할 수 있다.
	Map은 모든 형태의 객체데이터를 key와 Value값으로 사용할 수 있지만
	Properties는 key와 value값으로 String만 사용할 수 있다.
	
	Map은 put(), get()메서드를 이용하여 데이터를 입출력 하지만 
	Properties는 setProperty(), getProperty()메서드를 통해서 데이터를
	입출력 한다.
 */
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.setProperty("name", "홍길동");
		prop.setProperty("tel", "010-1111-1111");
		prop.setProperty("addr", "대전");
		
		String name = prop.getProperty("name");
		String tel = prop.getProperty("tel");
		
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + tel);
		System.out.println("주소 : " + prop.getProperty("addr"));
	}
}