package com.bb.injection.dao;

import com.bb.injection.model.User;
import com.bb.injection.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ankit on 27/5/16.
 */
public class UserDao {

    private UserDao(){}

    private static UserDao userDao=new UserDao();

    public static UserDao getInstance(){
        return userDao;
    }

    public void insert(List<User> users) {
        List<String> userInserts = users.stream().map(User::getInsert).collect(Collectors.toList());
        Connection connection = ConnectionUtil.getConnection();
        Statement statement=null;
        try {
             statement = connection.createStatement();
            System.out.println("Adding queries to batch");
            for (String query : userInserts) {
                System.out.println(query);
                statement.addBatch(query);
            }
            statement.executeBatch();
//            for (String query : userInserts) {
//                statement.execute(query);
//           }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            ConnectionUtil.closeStatement(statement);
            ConnectionUtil.closeConnection(connection);
        }

    }
}
