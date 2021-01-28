package co.micol.board.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO { // 상위 클래스
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 디비의 위치
	private String user = "micol";
	private String password = "1234";
	
	public Connection conn;
	
	public DAO() {
		try {
			Class.forName(driver); // driver load
			conn = DriverManager.getConnection(url, user, password);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
