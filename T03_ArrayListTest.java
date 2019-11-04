package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
	문제) 5명의 사람이름을 입력하여 ArrayList에 저장하고 이 중에 '김'씨 성의 이름을 출력하시오.
		입력은 Scanner를 이용하여 입력받는다.
 */
public class T03_ArrayListTest {
	public static void main(String[] args) {
		
		ArrayList<String> name = new ArrayList<String>();
		
		Scanner sc = new Scanner(System.in);
		String b = "김";
	
		System.out.println("이름을 입력하세여");
		String s1 = sc.nextLine();
		name.add(s1);
		String s2 = sc.nextLine();
		name.add(s2);
		String s3 = sc.nextLine();
		name.add(s3);
		String s4 = sc.nextLine();
		name.add(s4);
		String s5 = sc.nextLine();
		name.add(s5);
		System.out.println("\n\n");
		for(int i =0; i<name.size(); i++) {
			String a = name.get(i).substring(0,1);
			if(a.equals(b)) {
				System.out.println(name.get(i));
			}
		}
	}
}
