package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class T02_JdbcTest {
/*
	문제 1) 사용자로부터 lprod_id 값을 입력받아 입력한 값보다
	       lprod_id가 큰 자료들을 출력하시오.
	       
	문제 2) lprod_id값을 2개 입력받아서 두 값 중 작은 값부터 큰값 사이의
	자료를 출력하시오.
 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		// DB 작업에 필요한 객체변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String userId = "pc10";
			String password = "java";
			
			conn = DriverManager.getConnection(url, userId, password);
			
			stmt = conn.createStatement();
			
			//1번문제
//			System.out.print("값을 입력하세요 : ");
//			int a = sc.nextInt(); 
//			String sql = "select * from lprod where " + a + "<lprod_id"; //1번문제 
			
			//2번문제
			System.out.print("첫번째 값을 입력하세요 : ");
			int b = sc.nextInt();
			System.out.print("두번째 값을 입력하세요 : ");
			int c = sc.nextInt();
			String sql = "select * from lprod where lprod_id between " + b +" and " + c; //2번문제
			
			
			rs = stmt.executeQuery(sql); //SQL문이 select일 경우에는
			System.out.println("실행한 쿼리문 : " + sql);
			System.out.println("=== 쿼리문 실행 결과 ===");
			
			while(rs.next()) {
				System.out.println("lprod_id : " + rs.getInt("lprod_id"));
				System.out.println("lprod_gu : " + rs.getString("lprod_gu"));
				System.out.println("lprod_nm : " + rs.getString("lprod_nm"));
				System.out.println("-----------------------------------");
			}
			System.out.println("출력 끝...");
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 6. 종료(사용했던 자원을 모두 반납한다.)
			sc.close();
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(stmt != null) try {stmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}
}
