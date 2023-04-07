package arief.belajar.java.database;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class AutoIncrementTest {
    @Test
    void testAutoIncrement() throws SQLException {
        Connection connection =ConnectionUtil.getDataSource().getConnection();
        String sql = "insert into comments(email, comment) values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1,"karditya@test.com");
        preparedStatement.setString(2,"hi");

        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()){
            System.out.println("id comment : " + resultSet.getInt(1));
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
