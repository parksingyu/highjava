package studymyself;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWrite {

	public static void main(String[] args) throws IOException{
		FileOutputStream output = new FileOutputStream("D:/D_Other/out.txt");
		output.close();
		// D:/D_Other에 out.txt 파일을 만들어주는 구문
	}
}