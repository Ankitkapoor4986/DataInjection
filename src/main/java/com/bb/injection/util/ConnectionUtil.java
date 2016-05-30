package com.bb.injection.util;

import com.bb.injection.constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ankit on 30/5/16.
 */
public class ConnectionUtil {


    public static final String JDBC_MYSQL_LOCALHOST = "jdbc:mysql://localhost:3306/";
    public static final String ROOT_USERNAME_AND_PASSWORD = "root";
    public static final String LPORTAL_DB="lportal_generated";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    JDBC_MYSQL_LOCALHOST.concat(LPORTAL_DB),
                    ROOT_USERNAME_AND_PASSWORD,
                    ROOT_USERNAME_AND_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeStatement(Statement statement) {
        try {
            if (statement != null && !statement.isClosed())
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
