package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
	문제1) 5명의 별명을 입력하여 ArratList에 저장하고 별명의 길이가 제일 긴 별명을 출력하시오.
		(별명의 길이는 모두 다르게 입력한다.)
	문제2) 문제 1에서 별명의 길이가 같은 것을 여러개 입력했을때도 출력되도록 처리하시오.
 */
public class T04_ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> nick = new ArrayList<String>();
		
		String ln = null;
		int leng = 0;
		
		nick.add("aaa");
		nick.add("aaaaaaaaa");
		nick.add("aaaaaaaa");
		nick.add("cccccccccccc");
		nick.add("dddddddddddddd");
		nick.add("ee");
		nick.add("ffffff");
		nick.add("ggg");
//		int a = nick.get(0).length();
//		
//		for(int i = 0; i<nick.size()-1; i++) {
//			if ( ln.length() < nick.get(i+1).length()) {
//				leng = nick.get(i).length();
//			}
//		}
		
		ln = nick.get(0);
		for(int i=0; i<nick.size()-1; i++) {
			if ( ln.length() < nick.get(i+1).length()) {
				ln = nick.get(i+1);
			}
		}
		System.out.println(ln);
	}
}
