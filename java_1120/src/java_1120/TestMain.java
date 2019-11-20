package java_1120;

import java.sql.*;
import java.util.Scanner;

import org.mariadb.jdbc.*;

public class TestMain {
	static Scanner scan=new Scanner(System.in);
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestMain test =new TestMain();
		test.connectDB();
		//test.registerStudent();
		test.printDB();
		//test.findDB();
		test.closeDB();
		
	}
	public void connectDB() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/mydb","root","gkduddl");
			if(conn !=null) {
				System.out.println("DB접속 성공");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("JDBC 드라이버 로드 실패");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
			
		}
		
		
	}
	public void registerStudent() {
		System.out.println("학생 정보(이름 국어 영어)를 입력해 주세요 : ");
		String name =scan.next();
		int kor =scan.nextInt();
		int eng =scan.nextInt();
		scan.nextLine();
		String sql="insert into student values(?,?,?)";
		if(conn!=null) {
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setInt(2, kor);
				pstmt.setInt(3, eng);
				pstmt.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void printDB() {
		String sql="select * from student";
		if(conn!=null) {
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					String name =rs.getString(1);
					int kor=rs.getInt(2);
					int eng=rs.getInt(3);
					System.out.println(name+", "+kor+", "+eng);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void findDB() {
		String sql="select * from student where name=?";
		if(conn!=null) {
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, "이길동");
				rs=pstmt.executeQuery();
				while(rs.next()) {
					String name =rs.getString(1);
					int kor=rs.getInt(2);
					int eng=rs.getInt(3);
					System.out.println(name+", "+kor+", "+eng);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void closeDB() {
		
		try {
			pstmt.close();
			conn.close();
			rs.close();
			System.out.println("DBclose");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


