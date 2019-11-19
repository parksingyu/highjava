package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
	LPROD 테이블에 새로운 데이터를 추가하기

	lprod_gu와 lprod_nm은 직접 입력받아 처리하고
	lprod_id는 현재의 lprod_id들 중 제일 큰 값보다 1증가된 값으로 한다.
	(기타사항 : lprod_gu도 중복되는지 검사한다.)

 */
public class T04_JdbcTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> al = new ArrayList<String>();
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "pc10", "java");
			
			/*
			stmt = conn.createStatement();

			String sql = "insert into lprod " + "(lprod_id, lprod_gu, lprod_nm)" + "values (101, 'N101', '농산물') ";

			// SQL문이 select문이 아닐 경우에는 executeUpdate()메서드를
			// 사용한다. execureUpdate()메서드는 실행에 성공한 레코드 수를 반환한다.

			int cnt = stmt.executeUpdate(sql);
			System.out.println("첫번째 반환값 : " + cnt);

			//---------------------------------------------------------
			sql = "insert into lprod " + "(lprod_id, lprod_gu, lprod_nm)" + "values (102, 'N102', '수산물') ";
			cnt = stmt.executeUpdate(sql);
			System.out.println("두번째 반환값 : " + cnt);
			//---------------------------------------------------------
			sql = "insert into lprod " + "(lprod_id, lprod_gu, lprod_nm)" + "values (103, 'N103', '축산물') ";
			cnt = stmt.executeUpdate(sql);
			System.out.println("세번째 반환값 : " + cnt);
			 */

			// PreparedStatement 객체를 이용한 자료 추가 방법
			// SQL문 작성(데이터가 들어갈 자리에 물음표(?)를 넣는다.)

			stmt = conn.createStatement();
			String sql = "select * from lprod order by lprod_id"; //실행할 SQL문 최대값을 구하기 위해 반드시 order by를 입력한다.
			rs = stmt.executeQuery(sql); //SQL문이 select일 경우.

			//id의 max값 +1 하는 코드
			int imax = 0;
			while(rs.next()) {
				int id = rs.getInt("lprod_id");
				imax = id+1; // 최대값 + 1 하는 코드
				al.add(rs.getString("lprod_gu")); // lprod_gu값이 겹치지 않는 구문을 만들기 위해 lprod_gu에 있는 내용들을 arrayList로 넣는 코드.
			}

			// lprod_gu값이 겹치지 않게 하는 코드
			String gu = null;
			while(true) {
				int count = 0;
				System.out.print("lprod_gu : ");
				gu = sc.nextLine();
				for(int i = 0; i<al.size(); i++) {
					String igu = al.get(i);
					if (gu.equals(igu)) {
						System.out.println("이미 있는 값입니다. 다시 입력하세요.");
						count++;
					}
				}
				if (count == 0) {
					break;
				}
			}

			System.out.print("lprod_nm : ");
			String nm = sc.nextLine();

			// PreparedStatement객체를 생성할 때 SQL문을 넣어서 생성한다.
			sql = "insert into lprod (lprod_id, lprod_gu, lprod_nm) values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 쿼리문의 물음표(?)자리에 들어가 데이터를 셋팅한다.
			// 형식) pstmt.set자료형이름(물음표순번, 데이터);
			//		물음표 순번은 1번부터 시작한다.
			pstmt.setInt(1, imax);
			pstmt.setString(2, gu);
			pstmt.setString(3, nm);

			// 데이터를 세팅한 후 쿼리문을 실행한다.
			int cnt = pstmt.executeUpdate();
			System.out.println("첫번째 반환값 : " + cnt);
			//---------------------------------------------
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 6. 종료(사용했던 자원을 모두 반납한다.)
			sc.close();
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(stmt != null) try {stmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}
}