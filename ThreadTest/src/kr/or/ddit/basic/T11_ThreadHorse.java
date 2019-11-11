package kr.or.ddit.basic;

import java.util.ArrayList;

/*
 	3개(명)의 쓰레드가 각각 알파벳 대문자를 출력하는데 출력을 끝낸 순서대로
 	나타내는 프로그램 작성하기.
 */
public class T11_ThreadHorse {
	static ArrayList<String> rk = new ArrayList<String>();
	public static void main(String[] args) {
//		Horse[] disChars = new Horse[] {
//				new Horse("0번 말"),
//				new Horse("1번 말"),
//				new Horse("2번 말"),
//				new Horse("3번 말"),
//				new Horse("4번 말"),
//				new Horse("5번 말"),
//				new Horse("6번 말"),
//				new Horse("7번 말"),
//				new Horse("8번 말"),
//				new Horse("9번 말")
//		};
//		for(int i = 0; i < disChars.length; i++) {
//		disChars[i].start();
//		//disChars[i].setPriority(i+1);
//	}
//
//	for(Horse dc : disChars) {
//		try {
//			dc.join();
//		} catch(InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
		
		ArrayList<Object> dischars2 = new ArrayList<Object>();
		dischars2.add(new Horse("1번 말"));
		dischars2.add(new Horse("2번 말"));
		dischars2.add(new Horse("3번 말"));
		dischars2.add(new Horse("4번 말"));
		dischars2.add(new Horse("5번 말"));
		dischars2.add(new Horse("6번 말"));
		dischars2.add(new Horse("7번 말"));
		dischars2.add(new Horse("8번 말"));
		dischars2.add(new Horse("9번 말"));
		dischars2.add(new Horse("0번 말"));
		
		for(int i=0; i < dischars2.size(); i++) {
			((Thread) dischars2.get(i)).start();
		}
		
		for(Object dc : dischars2) {
			try {
				((Thread) dc).join();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("경기 끝...");
		System.out.println("------------------------------");
		System.out.println();
		System.out.println("------------경기 결과------------");

		for(int i = 0; i < 10; i++) {
			System.out.println( (i+1) + "등 : " + rk.get(i));
		}
	}
}

// 영어 대문자를 출력하는 쓰레드 클래스
class Horse extends Thread{
	private String name;
	// 생성자
	public Horse(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		//synchronized (this) {
			int distance = 70;
			for(int i = 0; i<distance; i++) {
				//lock.lock(); // 시작
				try {////
					//sleep()메서드의 값을 0~650 사이의 난수로 한다.
					String str = "";
					//Thread.yield();
					Thread.sleep((int)(Math.random()* 150));
					for(int j = 0; j<distance; j++) {
						if( i == j) {
							str += '>';
						} else {
							str += '-';
						} 
						if ( j == distance-1) {
							System.out.println(name + " : " + str);
						}
					}
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				//lock.unlock(); //해제
				
//				try {
//					//sleep()메서드의 값을 0~650 사이의 난수로 한다.
//					Thread.yield();
//					Thread.sleep((int)(Math.random()* 650));
//
//				} catch(InterruptedException e) {
//					e.printStackTrace();
//				}
				
			}
		//} synchronized (this) { <== 와 짝
		System.out.println(name + "이 도착했습니다.");
		T11_ThreadHorse.rk.add(name);
	}
}