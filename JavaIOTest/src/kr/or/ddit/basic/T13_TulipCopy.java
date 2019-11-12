package kr.or.ddit.basic;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class T13_TulipCopy {
	public static void main(String[] args) throws IOException {
		// 문자 기반의 스트림을 이용한 파일 내용 읽기
		FileReader fr = null;
		
		FileReader fr2 = null;

		// 문자 단위의 입력을 담당한 Reader형 객체 생성
		//fr = new FileReader("d:/D_Other/testChar.txt");
		fr = new FileReader("d:/D_Other/Tulips.jpg");
		fr2 = new FileReader("d:/D_Other/copy_Tulips.jpg");
		
		
		int c;

		while((c=fr.read()) != -1) {
			System.out.print((char) c);
		}
		
		fr.close();
		
		
		////////////
//		InputStreamReader isr = new InputStreamReader(System.in);
//		
//		FileWriter fw = null; // 파일 출력용 문자기반 스트림
//		
//		try {
//			// 파일 출력용 문자 스트림 객체 생성
//			fw = new FileWriter("d:/D_Other/testChar.txt");
//			
//			int a;
//			
//			System.out.println("아무거나 입력하세요.");
//			
//			// 콘솔에서 입력할 때 입력의 끝 표시는 Ctrl + Z키를 누르면 된다.
//			while((a=isr.read()) != -1) {
//				fw.write(a); //콘솔에서 입력받은 값을 파일에 출력하기.
//			}
//			
//			System.out.println("작업 끝");
//			
//			isr.close();
//			fw.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
	}
}
