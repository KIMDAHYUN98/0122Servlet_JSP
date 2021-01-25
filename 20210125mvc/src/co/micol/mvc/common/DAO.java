package co.micol.mvc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "hr";
	private String password = "hr";
	
	//���(public O, private X)
	public Connection conn;
	
	public DAO() { // ���� DAO CLASS
		try {
			Class.forName(driver); // ����̹� �ε�
			conn = DriverManager.getConnection(url, user, password); // �ڹٿ� DB ����
			System.out.println("DB ���� ����!");
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println("DB ���� ����!");
		}
	}
}
