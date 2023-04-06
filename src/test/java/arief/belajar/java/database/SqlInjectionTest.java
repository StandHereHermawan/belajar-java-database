package arief.belajar.java.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlInjectionTest {
    @Test
    void testSqlInjection() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String username = "admin';#'" ;
        String password = "rahasia1" ;

        String sql = "SELECT * FROM admin WHERE username = '" + username +
                "' AND PASSWORD ='" + password + "'" ;

        System.out.println(sql);

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            //Berhasil Login
            System.out.println("Sukses Login : " + resultSet.getString("username"));
        } else {
            System.out.println("Gagal Login");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
