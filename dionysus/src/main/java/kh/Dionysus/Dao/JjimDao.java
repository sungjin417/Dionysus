package kh.Dionysus.Dao;

import kh.Dionysus.Utills.Common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JjimDao {
    private Connection conn = null;
    private PreparedStatement pStmt = null;

    public void toggleJjim(String userId, String alcoholName, boolean jjim) throws SQLException {
        String sql = "INSERT INTO JJIM_TB (USER_ID, ALCOHOL_NAME, JJIM) VALUES (?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE JJIM = ?";
        try {
            conn = Common.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, userId);
            pStmt.setString(2, alcoholName);
            pStmt.setBoolean(3, jjim);
            pStmt.setBoolean(4, jjim);
            pStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Common.close(conn);
            Common.close(pStmt);
        }
    }
}
