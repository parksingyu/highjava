package kr.or.ddit.basic;

import java.util.SortedSet;
import java.util.TreeSet;

public class T10_SetTest {
	public static void main(String[] args) {
		//HashSet은 데이터에 순서가 없으나 (등록되는 순서를 알지 못한다)
		//TreeSet은 자동 정렬 기능이 들어가 있다.
		
		TreeSet<String> ts = new TreeSet<>();
		
		//영어 대문자를 문자열로 변환하여 TreeSet에 저장
		for(char ch = 'Z'; ch >= 'A'; ch--) {  
			//for(char ch = 'A'; ch <= 'Z'; ch++) 도 똑같다. 정렬이 잘되는지 확인하기 위해서 거꾸로 넣어본것.     
			String temp = String.valueOf(ch);
			ts.add(temp);
		}
		
		System.out.println("TreeSet 자료 : " + ts);
		
		// TreeSet에 저장된 자료 중 특정한 자료보다 작은 자료를 찾아서
		// SortedSet으로 변환하는 메서드가 있다.
		// => headSet(기준값)메서드 (기본적으로 '기준값'은 포함시키지 않는다)
		// => headSet(기준값, 논리값) (논리값이 true이면 '기준값'을 포함)
		SortedSet<String> ss1 = ts.headSet("K");
		System.out.println("K 이전 자료 : " + ss1); // 기존값 미포함
		System.out.println("K 이전 자료(기준값 포함) : " + ts.headSet("K", true)); // 기준값 포함
		
		// '기준값' 보다 큰 자료를 찾아 SortedSet으로 반환하는 메서드
		// tailSet(기준값)   => 기본적으로 '기준값'을 포함시킨다.
		// tailSet(기준값, 논리값)   => 논리값이 false이면 '기준값'을 포함하지 않음.
		SortedSet<String> ss2 = ts.tailSet("K");
		System.out.println("K 이후 자료 : " + ss2); // 기준값 포함
		System.out.println("K 이후 자료(기준값 미포함) : "
				+ ts.tailSet("K", false)); // 기준값 미포함
		
		// subSet(기준값1, 기준값2) => 기준값1~기준값2 사이의 값을 가져온다.
		//                         ('기준값1' 포함, '기준값2' 미포함)
		// subSet(기준값1, 논리값1, 기준값2, 논리값2) => 각 기준값을 포함할지 여부 설정함.(논리값이 true이면 포함, false이면 미포함)
		System.out.println("");
		System.out.println("K(포함)부터 N(미포함)까지 : " + ts.subSet("K", "N"));
		System.out.println("K(포함)부터 N(포함)까지 : " + ts.subSet("K", true, "N", true));
		System.out.println("K(미포함)부터 N(미포함)까지 : " + ts.subSet("K", false, "N", false));
		System.out.println("K(미포함)부터 N(포함)까지 : " + ts.subSet("K", false, "N", true));
	}
}