package arief.belajar.java.database;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class DriverTest {

    @Test
    void testRegister() {
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        }catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }
}
