package studymyself;

import java.io.FileWriter;
import java.io.IOException;

public class FileWrite4 {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("D:/D_Other/out.txt");
		for(int i = 1; i<11; i++) {
			String data = i+"번째 줄입니다.\r\n";
			fw.write(data);
		}
		fw.close();
		
		FileWriter fw2 = new FileWriter("D:/D_Other/out.txt", true);
		for(int i=11; i<21; i++) {
			String data = i+"번째 줄입니다.\r\n";
			fw2.write(data);
		}
		fw2.close();
	}
}

//fw2라는 객체는 FileWriter("c:/out.txt", true) 와 같이 
//두번째 입력값이 추가로 입력되어 생성되었다. 
//두번째 boolean 입력 파라미터는 파일을 추가모드(append)로 열것인지에 대한 구분값이다. 
//파일을 추가모드로 열면 기존파일의 내용이후부터 파일이 쓰여지게 된다.