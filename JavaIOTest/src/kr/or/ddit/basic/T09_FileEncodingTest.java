package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	InputStreamReader객체는 파일의 인코딩 방식을 지정할 수 있다. 
	형식) new InputStreamReader(바이트기반스트림객체, 인코딩 방식)
	인코딩 방식
	한글 인코딩 방식을 크게 두가지로 나뉜다(UTF-8 과 EUC-KR)
	원래 한글윈도우는 CP949방식을 사용했는데, 윈도우를 개발한 마이크로소프트에서
	EUC-KR방식에서 확장하였기 때문에 MS949라고도 부른다.
	CP949는 EUC-KR의 확장이며, 하위 호환성이 있다.
	-MS949 => 윈도우의 기본 한글 인코딩 방식(ANSI계열)
	-UTF-8 => 유니코드 UTF-8 인코딩 방식(영문자 및 숫자 : 1byte, 한글 :3byte)
	-US-ASCII => 영문 전용 인코딩 방식
	
	ANSI는 영어를 표기하기 위해 만든 코드로 규격 자체에 한글이 없었다가
	나중에 여기에 EUC-KR, CP949라는 식으로 한글이 포함됨.
	
	참고)
	-----------------------------------------------------------
	ASCII => extended ASCII(ISO 8859-1) => 조합형, 완성형(KSC 5601)
	-----------------------------------------------------------
		=> 윈도우 계열 : CP949(확장 완성형)			=> 유니코드(Unicode)
		=> 유닉스 계열 : EUC-KR(확장 유닉스 코드)
	-----------------------------------------------------------
*/

public class T09_FileEncodingTest {
	public static void main(String[] args) {
		// 파일 인코딩을 이용하여 읽어오기
		FileInputStream fin = null;
		InputStreamReader isr = null;
		
		
		try {
			// FileInputStream객체를 생성한 후 이 객체를 매개변수로 받는
			//InputStreamReader객체를 생성한다.
			fin = new FileInputStream("d:/D_Other/test_utf8.txt"); //(fin)과 짝
			//fin = new FileInputStream("d:/D_Other/test_ansi.txt");  //(fin, "MS949") 과 짝
			
			isr = new InputStreamReader(fin);
			//isr = new InputStreamReader(fin, "MS949");
			
			int c;
			while((c=isr.read()) != -1) {
				System.out.print((char)c);
			}
			
			System.out.println();
			System.out.println("출력 끝...");
			
			isr.close(); //보조스트림만 닫아도 된다.
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}