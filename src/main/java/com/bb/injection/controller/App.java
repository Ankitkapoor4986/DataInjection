package com.bb.injection.controller;

import com.bb.injection.Service.AddressService;
import com.bb.injection.Service.GeoCodeService;
import com.bb.injection.Service.TBBBuddyGroupService;
import com.bb.injection.Service.UserService;
import com.bb.injection.model.Address;
import com.bb.injection.model.TBBBuddyGroup;
import com.bb.injection.model.User;
import com.bb.injection.util.PropertyUtil;

import java.util.List;
import java.util.Optional;

/**
 * Created by ankit on 30/5/16.
 */
public class App {

    public static String PATH = null;

    public static void main(String[] args) {


        //TODO improve address code generation
        //TODO Error in GOOGLE API
        //
        //TODO Check status in API
        //TODO Convert GeoCoding loop into iterator

        PATH = Optional.of(args[0]).get();

        UserService userService = UserService.getInstance();

        if (Boolean.parseBoolean(PropertyUtil.getProperty(PropertyUtil.INSERT_USER))) {
            List<User> users = userService.generate();
            userService.insert(users);
        }
        AddressService addressService = AddressService.getInstance();
        if (Boolean.parseBoolean(PropertyUtil.getProperty(PropertyUtil.UPDATE_ADDRESS))) {
            addressService.updateAddress();
        }
        List<Address> addresses = addressService.getAddress();
        GeoCodeService geoCodeService = GeoCodeService.getInstance();
         geoCodeService.getTBBGroupFromAddress(addresses);



    }
}
