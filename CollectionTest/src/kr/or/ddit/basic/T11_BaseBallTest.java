package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class T11_BaseBallTest {
/*
 	문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
 		컴퓨터의 숫자는 난수를 이용하여 구한다.
 		(스트라이크는 'S', 볼은 'B'로 출력한다.)
 		
 		컴퓨터의 난수가 9 5 7 일 경우 실행 예시
 		숫자 입력 => 3 5 6
 		3 5 6 => 1S 0B
 		숫자입력 => 7 8 9
 		7 8 9 => 0S 2B
 		...
 		숫자입력 = > 9 5 7 
 		9 5 7 => 3S 0B
 		
 		5번째 만에 맞췄군요.
 */
	public static void main(String[] args) {
		int count = 0;
		int s = 0;
		int b = 0;
		
		HashSet<Integer> intRnd = new HashSet<>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		while(intRnd.size() < 3) {  //Set의 데이터 3개가 될때까지 반복
			int num = (int)(Math.random() * 9 + 1);//1~9사이 난수
			
			if(intRnd.add(num)) {   //이걸 하지 않으면 정렬이 수가 정렬이 된다.
				a.add(num);
			}
		}
		
		System.out.println("");
		
		for(int i =0; i<a.size(); i++) {
			//System.out.print(a.get(i));
		}
		// 여기까지 컴퓨터의 난수 생성 까지
		
		System.out.println();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("3자리 숫자 입력하세요 : ");
			
			int mya = Integer.parseInt(sc.nextLine());
			
			int a1 = (mya / 10)  / 10;	 //입력값 백의 자리 
			int a2 = (mya % 100) / 10;	 //입력값 십의 자리
			int a3 = mya % 10 ; 		 //입력값 일의 자리
			
			int aa1 = a.get(0); 		 //랜덤값 백의 자리
			int aa2 = a.get(1); 		 //랜덤값 십의 자리
			int aa3 = a.get(2); 		 //랜덤값 일의 자리
			
			if( a1 == aa1 ) {
				s++;
			} else if ( a1 == aa2 || a1 == aa3) {
				b++;
			}
			
			if(a2 == aa1 || a2 == aa3){
				b++;
			} else if(a2 == aa2){
				s++;
			}
			
			if(a3 == aa1 || a3 == aa2){
				b++;
			} else if(a3 == aa3){
				s++;
			}
			
			count++;
			System.out.println("결과 : "+s+"s "+b+"b");
			if ( s == 3 ) {
				System.out.println(count+"번째 만에 맞췄군요.");
				break;
			}
			s = 0;
			b = 0;
		}
	}
}