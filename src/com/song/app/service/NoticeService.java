package com.song.app.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class NoticeService {

    public void retrieveData() {
        try {
            String url = "jdbc:oracle:thin:@localhost:1521/xe";
            String sql = "SELECT * FROM NOTICE";

            // JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, "SYSTEM", "gjgkgl135");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String write_id = rs.getString("WRITER_ID");
                Date regdate = rs.getDate("REGDATE");
                String content = rs.getString("CONTENT");
                int hit = rs.getInt("HIT");

                System.out.printf("id :%d, title:%s, write_id:%s, regDate:%s, content:%s, hit:%d \n", id, title, write_id, regdate, content, hit);
            }

            rs.close();
            st.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("오라클 JDBC 드라이버를 찾을 수 없습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("데이터베이스 연결 또는 쿼리 수행 중 오류가 발생했습니다.");
        }
    }
}
