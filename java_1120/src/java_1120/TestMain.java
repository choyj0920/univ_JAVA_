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
				System.out.println("DB���� ����");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("JDBC ����̹� �ε� ����");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("DB ���� ����");
			e.printStackTrace();
			
		}
		
		
	}
	public void registerStudent() {
		System.out.println("�л� ����(�̸� ���� ����)�� �Է��� �ּ��� : ");
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
				pstmt.setString(1, "�̱浿");
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


