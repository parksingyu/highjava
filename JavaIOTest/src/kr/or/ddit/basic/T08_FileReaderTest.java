package kr.or.ddit.basic;

import java.io.FileReader;
import java.io.IOException;

public class T08_FileReaderTest {
	public static void main(String[] args) throws IOException {
		// 문자 기반의 스트림을 이용한 파일 내용 읽기
		FileReader fr = null;
		
		// 문자 단위의 입력을 담당한 Reader형 객체 생성
		fr = new FileReader("d:/D_Other/testChar.txt");
		
		int c;
		
		//방법1
		while((c=fr.read()) != -1) {
			System.out.print((char) c);
		}
		
		//방법2
//		char[] charArr = new char[10]; //문자를 담을 배열 선언
//		while((c = fr.read(charArr)) != 1) {
//			// 문자 배열을 이용하여 스트링 객체 생성
//			String data = new String(charArr, 0, c);
//			System.out.println(data);
//		}
		
		fr.close();
	}
}
