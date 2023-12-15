package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {

    private static final String url = System.getProperty("db.url");
    private static final String user = System.getProperty("db.user");
    private static final String pass = System.getProperty("db.password");
    private static final QueryRunner queryRunner = new QueryRunner();

    private SQLHelper() {
    }

    private static Connection getConnect() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

    @SneakyThrows
    public static String getPaymentStatus() {
        var connection = getConnect();
        return queryRunner.query(connection, "SELECT status FROM payment_entity ORDER BY created DESC Limit 1", new ScalarHandler<String>());
    }

    @SneakyThrows
    public static String getCreditStatus() {
        var connection = getConnect();
        return queryRunner.query(connection, "SELECT status FROM credit_request_entity ORDER BY created DESC Limit 1", new ScalarHandler<String>());
    }

    @SneakyThrows
    public static void clearDB() {
        var connection = getConnect();
        queryRunner.execute(connection, "DELETE FROM payment_entity");
        queryRunner.execute(connection, "DELETE FROM credit_request_entity");
        queryRunner.execute(connection, "DELETE FROM order_entity");
    }
}
