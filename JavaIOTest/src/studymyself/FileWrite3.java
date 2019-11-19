package studymyself;

import java.io.FileWriter;
import java.io.IOException;

public class FileWrite3 {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("D:/D_Other/out.txt");
		for(int i = 1; i<1001; i++) {
			String data = i+"번째 줄입니다.\r\n";
			fw.write(data);
		}
		fw.close();
	}
}

//FileWrite2에서 는 output.write(data.getBytes());를 써야 했지만
//여기서는 바로 사용 가능하다. 이게 FileWriter의 장점이다.