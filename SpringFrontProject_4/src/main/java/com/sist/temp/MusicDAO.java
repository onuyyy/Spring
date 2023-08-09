package com.sist.temp;

import java.util.*;
import java.sql.*;

public class MusicDAO {

    private Connection conn;
    private PreparedStatement ps;
    private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

    public MusicDAO() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void musicInsert(Music m) {
        try {
            conn = DriverManager.getConnection(URL, "hr", "happy");
            String sql = "INSERT INTO genie_music "
                    + "VALUES((SELECT NVL(MAX(mno)+1,1) FROM genie_music),"
                    + "?,?,?,?,?,?,?,?)"; // 닫는 괄호 추가
            ps = conn.prepareStatement(sql);
            ps.setInt(1, m.getCno());
            ps.setString(2, m.getTitle());
            ps.setString(3, m.getSinger());
            ps.setString(4, m.getAlbum());
            ps.setString(5, m.getPoster());
            // 올바른 프로퍼티 이름 사용
            ps.setInt(6, m.getIdcrement()); // 수정
            ps.setString(7, m.getState());
            ps.setString(8, m.getKey());

            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
