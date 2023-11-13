package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "SELECT * FROM NOTICE WHERE HIT > 10";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "SYSTEM", "gjgkgl135");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String write_id = rs.getString("WRITER_ID");
			Date regdate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("HIT");
			
			System.out.printf("id :%d, title:%s, write_id:%s, regDate:%s, content:%s, hit:%d \n", id, title, write_id, regdate, content, hit);
		};
		
		
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
