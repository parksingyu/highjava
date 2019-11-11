package kr.or.ddit.basic;

import java.lang.reflect.Method;

public class AnnotationTest {
	public static void main(String[] args) throws Exception {
		
		System.out.println(PrintAnnotation.id);
		
		// reflection 기능을 이용한 메서드 실행
		Method[] declaredMethods = Service.class.getDeclaredMethods();
		
		for(Method m : declaredMethods) {
			System.out.println(m.getName());
			for(int i = 0 ; i<m.getDeclaredAnnotation(PrintAnnotation.class).count(); i++) { //PrintAnnotation의 count값 
				System.out.print(m.getDeclaredAnnotation(PrintAnnotation.class).value()); //PrintAnnotation의 value값 출력 : 
			}
			System.out.println(); // 줄바꿈 처리
			
			m.invoke(new Service()); // reflection기능을 이용한 메서드 실행
		}
	}
}