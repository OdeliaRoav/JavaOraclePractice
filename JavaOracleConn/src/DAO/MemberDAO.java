package DAO;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "hong1";
	String password = "1111";
	
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public ArrayList<MemberVo> list(){
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		
		try {
			conDB();
			
			String query = "SELECT * FROM emp";
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String empno = rs.getString("empno");
				String ename = rs.getString("ename");
				int sal = rs.getInt("sal");
				
				MemberVo data = new MemberVo(empno, ename, sal);
				list.add(data);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void conDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");
			stmt = con.createStatement();
			System.out.println("statement create success.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
