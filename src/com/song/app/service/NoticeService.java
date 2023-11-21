package com.song.app.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.song.app.entity.Notice;

public class NoticeService {

    public List<Notice> getList() throws ClassNotFoundException, SQLException{

    String url = "jdbc:oracle:thin:@localhost:1521/xe";
    String sql = "SELECT * FROM NOTICE";

    // JDBC 드라이버 로드
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection(url, "SYSTEM", "gjgkgl135");
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(sql);

    List<Notice> list = new ArrayList<Notice>();
    
    while (rs.next()) {
        int id = rs.getInt("ID");
        String title = rs.getString("TITLE");
        String write_id = rs.getString("WRITER_ID");
        Date regdate = rs.getDate("REGDATE");
        String content = rs.getString("CONTENT");
        int hit = rs.getInt("HIT");

        Notice notice = new Notice(
        		id,
        		title,
        		write_id,
        		regdate,
        		content,
        		hit
        		);
        
        list.add(notice);
    }

    rs.close();
    st.close();
    con.close();
    
    return list;

    }
}
