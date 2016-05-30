package com.bb.injection.inserters;

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
public class UserInserter {

    public void insert(List<User> users) {
        List<String> userInserts = users.stream().map(User::getInsert).collect(Collectors.toList());
        Connection connection = ConnectionUtil.getConnection();
        Statement statement=null;
        try {
             statement = connection.createStatement();
            for (String query : userInserts) {
                statement.addBatch(query);
            }
            statement.executeBatch();
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            ConnectionUtil.closeStatement(statement);
            ConnectionUtil.closeConnection(connection);
        }

    }
}
