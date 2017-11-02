package Process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	Connection conn;
	Statement stmt;
    private ResultSet rs;
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public Statement getStmt() {
		return stmt;
	}
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
	
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	public boolean connectionDB(){
		boolean result =true;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/**
			 * bms는 생성한 데이터베이스의 이름
			 * root는 아이디
			 */
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","mysql");
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement();
			stmt.executeUpdate("create table members"
					+ "(ID char(10) not null,"
					+ "PW char(10) not null,"
					+ "account int not null,"
					+ "primary key(ID)"
					+ ");");
			
			stmt.executeUpdate("insert into members(ID,PW,account) values('shin1227','12345','50000');");
			
			stmt.executeUpdate("create table menu(menuID char(10) not null,menuName char(10) not null,menuPrice int not null,primary key(menuID));");
			stmt.executeUpdate("create table receipt(date datetime not null, receiptNum char(10) not null,type int not null, account int not null);");
			stmt.executeUpdate("insert into menu values('A0','kimchi','4000');");
			stmt.executeUpdate("insert into menu values('A1','spagetti','5000');");
			stmt.executeUpdate("insert into menu values('A2','beefRice','5000');");
			stmt.executeUpdate("insert into menu values('A3','kimbap','7000');");
			stmt.executeUpdate("insert into menu values('A4','fucking','10000');");
			stmt.executeUpdate("insert into menu values('A5','steak','15000');");
			stmt.executeUpdate("insert into menu values('A6','hh','6000');");
			stmt.executeUpdate("insert into menu values('A7','soju','3000');");
			stmt.executeUpdate("insert into menu values('A8','beer','4000');");
			stmt.executeUpdate("insert into menu values('A9','beverage','1500');");
			System.out.println("Statement 생성 완료");
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
			result =false;
		}
		return result;
	}	
}
