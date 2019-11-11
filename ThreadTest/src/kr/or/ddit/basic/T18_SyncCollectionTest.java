package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T18_SyncCollectionTest {
	//동기화를 하지 않을 경우
	private static List<Integer> list1 = new ArrayList<Integer>();
	
	//동기화 하는 경우
	//collections의 정적 메서드 중에서 synchronized로 시작하는 메서드 이름
	private static List<Integer> list2 = Collections.synchronizedList(new ArrayList<Integer>());
	
	public static void main(String[] args) {
		//익명 쓰레드로 쓰레드 구현
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i<1000000000; i++) {
					list1.add(i); //동기화 처리 하지 않은 리스트 사용
				}
			}
		};
		
		Thread[] ths = new Thread[] {
			new Thread(r), new Thread(r),
			new Thread(r), new Thread(r), new Thread(r)
		};
		
		for(Thread th : ths) {
			try {
				th.join();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("list1의 개수 : " + list1.size());
	}
}
