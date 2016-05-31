package com.bb.injection.dao;

import com.bb.injection.constants.Constants;
import com.bb.injection.model.Address;
import com.bb.injection.model.User;
import com.bb.injection.util.ConnectionUtil;

import javax.naming.spi.DirStateFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by ankit on 30/5/16.
 */
public class AddressDao {

    public List<Long> getAddressId() {
        List<Long> addressIds = new ArrayList<>();
        StringBuilder addressIdQuery = new StringBuilder("select addressId from  ")
                .append(Constants.ADDRESS_TAB_NAME)
                .append("order by addressId  limit ").append(Constants.TOTAL_ROWS);
        try(Connection connection = ConnectionUtil.getConnection();
            Statement   statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(addressIdQuery.toString())) {
            while (rs.next()) {
                addressIds.add(rs.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

            return addressIds;
    }

    //// TODO: 31/5/16 Improve that code
    //// merge the collection
    //// execute batch
    public void updateAddress(List<Long> addressId){
        StringBuilder adressUpdater=new StringBuilder();
        adressUpdater.append("update ").append(Constants.ADDRESS_TAB_NAME)
                .append(" set userId=? where addressId=?");
        try(Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(adressUpdater.toString())){
            for(int iterator=0;iterator<Constants.TOTAL_ROWS;iterator++){
                ps.setLong(1,iterator);
                ps.setLong(2,addressId.get(iterator));
                System.out.println(ps.toString());
                ps.executeUpdate();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }





}
