import java.sql.*;

public class OracleInsert {

    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "hong1";
        String password = "1111";

        try {
            // JDBC 드라이버 로딩
            Class.forName(driver);
            System.out.println("JDBC 드라이버 로딩 성공");

            // 데이터베이스 연결
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                System.out.println("Oracle 연결 성공\n");

                // MAX(deptno) 조회
                String sqlSelectMax = "SELECT MAX(deptno) AS maxDeptNo FROM dept";
                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery(sqlSelectMax)) {

                    int maxDeptNo = 0;
                    if (rs.next()) {
                        maxDeptNo = rs.getInt("maxDeptNo");
                    }
                    System.out.println("현재 최대 deptno: " + maxDeptNo);

                    // 새로운 데이터 삽입
                    String sqlInsert = "INSERT INTO dept (deptno, dname, loc) VALUES (?, ?, ?)";
                    try (PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {
                        pstmt.setInt(1, maxDeptNo + 10); // 새로운 deptno
                        pstmt.setString(2, "IT");        // 부서 이름
                        pstmt.setString(3, "SEOUL");     // 위치

                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("데이터 삽입 성공");
                        } else {
                            System.out.println("데이터 삽입 실패");
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버 로딩 실패: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL 오류: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
