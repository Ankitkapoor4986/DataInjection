package com.bb.injection.controller;

import com.bb.injection.Service.UserService;
import com.bb.injection.dao.UserDao;
import com.bb.injection.model.User;

import java.util.List;

/**
 * Created by ankit on 30/5/16.
 */
public class App {

    public static void main(String[] args){
        UserService userService=UserService.getInstance();
        List<User> users= userService.generate();
        userService.insert(users);
    }
}
