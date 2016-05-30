package com.bb.injection.Service;

import com.bb.injection.constants.Constants;
import com.bb.injection.dao.UserDao;
import com.bb.injection.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankit on 26/5/16.
 */
public class UserService {

    private static UserService userService=new UserService();
    private UserService(){}
    public static UserService getInstance(){
        return userService;
    }
    private UserDao userDao=UserDao.getInstance();

    public void insert(List<User> users){
        userDao.insert(users);
    }

    public List<User> generate() {
        List<User> users = new ArrayList<User>();
        for (int iterator = 0; iterator < Constants.TOTAL_ROWS; iterator++) {
            User user = new User();
            user.setEmailAddress(new StringBuilder(Constants.COMMON_EMAIL_PREFIX_BEFORE_NO)
                    .append(iterator).append(Constants.COMMON_EMAIL_PREFIX_AFTER_NO).toString());

            user.setFirstName(Constants.TEST_STR.concat(String.valueOf(iterator)));
            user.setLastName(Constants.TEST_STR.concat(String.valueOf(iterator)));
            user.setMiddleName(Constants.TEST_STR.concat(String.valueOf(iterator)));



            user.setScreenName(Constants.TEST_STR.concat(String.valueOf(iterator)));
            user.setUserId(iterator);
            user.setCreateDate(LocalDateTime.now());
            user.setModifiedDate(LocalDateTime.now());
            users.add(user);
        }
        return users;
    }





}
