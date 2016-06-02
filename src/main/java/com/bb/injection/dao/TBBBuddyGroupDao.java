package com.bb.injection.dao;

import com.bb.injection.model.TBBBuddyGroup;
import com.bb.injection.model.User;
import com.bb.injection.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ankit on 1/6/16.
 */
public class TBBBuddyGroupDao {

    private static TBBBuddyGroupDao buddyGroupDao =new TBBBuddyGroupDao();

    public static TBBBuddyGroupDao getInstance(){
        return buddyGroupDao;
    }

    public void insert(List<TBBBuddyGroup> users) {
        List<String> buddyGroupInsertsQueries = users.stream().map(TBBBuddyGroup::getInsert).collect(Collectors.toList());


        try (Connection connection = ConnectionUtil.getConnection();
             Statement statement = connection.createStatement();
        ) {

            System.out.println("Adding queries to batch");

            buddyGroupInsertsQueries.stream().forEach(s -> {
                        System.out.println(s);

                        try {
                            statement.addBatch(s);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
            );
            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
