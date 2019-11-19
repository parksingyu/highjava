package studymyself;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWrite2 {

	public static void main(String[] args) throws IOException {
		FileOutputStream output = new FileOutputStream("D:/D_Other/out.txt");
		for(int i=1; i<11; i++) {
			String data = i+"번째 줄입니다.\r\n";
			output.write(data.getBytes());
		}
		output.close();
	}
}
// 윈도우에서는 줄바꿈 : \r\n
/*1번째 줄입니다.
2번째 줄입니다.
3번째 줄입니다.
4번째 줄입니다.
5번째 줄입니다.
6번째 줄입니다.
7번째 줄입니다.
8번째 줄입니다.
9번째 줄입니다.
10번째 줄입니다.*/
//위와 같이 값이 입력됩니다.
