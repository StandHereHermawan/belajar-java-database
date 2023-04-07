package arief.belajar.java.database;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class DateTest {

    @Test
    void testDate() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = """
            insert into sample_time(sample_date, sample_time, sample_timestamp) values (?,?,?)
            """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setDate(1, new Date(System.currentTimeMillis()));
        preparedStatement.setTime(2, new Time(System.currentTimeMillis()));
        preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    @Test
    void testDateQuery() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "SELECT * FROM sample_time";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Time time = resultSet.getTime("Sample_time");
            System.out.println("Time = "+ time);
            Date date = resultSet.getDate("Sample_date");
            System.out.println("Date = "+ date);
            Timestamp timestamp = resultSet.getTimestamp("Sample_timestamp");
            System.out.println("Timestamp = "+ timestamp);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
