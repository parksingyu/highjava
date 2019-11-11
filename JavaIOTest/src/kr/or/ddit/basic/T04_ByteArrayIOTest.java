package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T04_ByteArrayIOTest {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4]; //자료를 읽을때 사용할 배열
		
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		try {
			while(input.available() > 0 ) {
				/*
				input.read(temp); 		//temp배열 크기만큼 읽어와 temp에 저장
				output.write(temp); 	//temp배열 내용 출력
				 */
				//실제 읽어온 byte수를 반환한다.
				int len = input.read(temp);
				
				//temp배열의 내용중에서 0부터 len 개수만큼 출력한다.
				output.write(temp, 0, len);
				System.out.println("temp : " + Arrays.toString(temp));
			}
			System.out.println();
			outSrc = output.toByteArray();
			
			System.out.println("inSrc => " + Arrays.toString(inSrc));
			System.out.println("outSrc => " + Arrays.toString(outSrc));
			
			input.close();
			output.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
