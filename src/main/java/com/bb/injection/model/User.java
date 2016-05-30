package com.bb.injection.model;

import com.bb.injection.constants.Constants;

import java.time.LocalDateTime;

/**
 * Created by ankit on 25/5/16.
 */
public class User extends  BaseDateDTO{

    private long userId;
    private String screenName;
    private String emailAddress;
    private String firstName;
    private String middleName;
    private String lastName;


    public long getCompanyId() {
        return Constants.COMPANY_ID;
    }

    public String getPassword() {
        return Constants.GENERAL_PASSWORD;
    }

    public boolean isPasswordEncrypted() {
        return Boolean.FALSE;
    }

    public boolean isPasswordReset() {
        return Boolean.FALSE;
    }



    public boolean isActive() {
        return Boolean.TRUE;
    }

    public String getLanguageId() {
        return Constants.US_LOCALE;
    }

    public String getInsert(){

        return new StringBuilder("Insert into User_ (userId,screenName,emailAddress,firstName,middleName,lastName")
                .append(",companyId,password_,passwordEncrypted_,passwordReset,passwordModifiedDate,active_,languageId)")
                .append("values ").append(Constants.OPEN_BRACKET)
                .append(Constants.SINGLE_COTE).append(userId).append(Constants.SINGLE_COTE).append(Constants.COMMA)
                .append(Constants.SINGLE_COTE).append(screenName).append(Constants.SINGLE_COTE).append(Constants.COMMA)
                .append(Constants.SINGLE_COTE).append(emailAddress).append(Constants.SINGLE_COTE).append(Constants.COMMA)
                .append(Constants.SINGLE_COTE).append(firstName).append(Constants.SINGLE_COTE).append(Constants.COMMA)
                .append(Constants.SINGLE_COTE).append(lastName).append(Constants.SINGLE_COTE).append(Constants.COMMA)
                .append(Constants.SINGLE_COTE).append(middleName).append(Constants.SINGLE_COTE).append(Constants.COMMA)
                .append(Constants.SINGLE_COTE).append(getCompanyId()).append(Constants.SINGLE_COTE)
                .append(Constants.COMMA)
                .append(Constants.SINGLE_COTE).append(getPassword()).append(Constants.SINGLE_COTE).append(Constants.COMMA)
                .append(Constants.SINGLE_COTE).append(isPasswordEncrypted()).append(Constants.SINGLE_COTE)
                .append(Constants.COMMA)
                .append(Constants.SINGLE_COTE).append(isPasswordReset()).append(Constants.SINGLE_COTE)
                .append(Constants.COMMA)
                .append(Constants.SINGLE_COTE).append(isActive()).append(Constants.SINGLE_COTE).append(Constants.COMMA)
                .append(Constants.SINGLE_COTE).append(getLanguageId()).append(Constants.SINGLE_COTE)
                .append(Constants.CLOSE_BRACKET)
                .toString();
    }



    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


}
