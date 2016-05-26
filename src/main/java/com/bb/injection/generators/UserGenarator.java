package com.bb.injection.generators;

import com.bb.injection.constants.Constants;
import com.bb.injection.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankit on 26/5/16.
 */
public class UserGenarator {

    public List<User> generate() {
        List<User> users = new ArrayList<User>();
        for (int iter = 0; iter < Constants.TOTAL_ROWS; iter++) {
            User user = new User();
            user.setEmailAddress(new StringBuilder(Constants.COMMON_EMAIL_PREFIX_BEFORE_NO)
                    .append(iter).append(Constants.COMMON_EMAIL_PREFIX_AFTER_NO).toString());
            user.setActive(true);
            user.setFirstName(Constants.TEST_STR.concat(String.valueOf(iter)));
            user.setLastName(Constants.TEST_STR.concat(String.valueOf(iter)));
            user.setMiddleName(Constants.TEST_STR.concat(String.valueOf(iter)));
            if (iter % 2 == 0) {
                user.setLanguageId(Constants.US_LOCALE);
            } else {
                user.setLanguageId(Constants.CANADA_LOCALE);
            }
            user.setPassword(Constants.TEST_STR);
            user.setPasswordEncrypted(false);
            user.setPasswordModifiedDate(LocalDateTime.now());
            user.setPasswordReset(false);
            user.setScreenName(Constants.TEST_STR.concat(String.valueOf(iter)));
            user.setUserId(iter);
            user.setCreateDate(LocalDateTime.now());
            user.setModifiedDate(LocalDateTime.now());
            users.add(user);
        }
        return users;
    }
}
