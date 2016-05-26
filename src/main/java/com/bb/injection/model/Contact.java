package com.bb.injection.model;

import java.time.LocalDateTime;

/**
 * Created by ankit on 25/5/16.
 */
public class Contact extends BaseDateDTO {
    private long contactId;
    private User user;
    private Contact parentContact;
    private LocalDateTime birthDate;

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Contact getParentContact() {
        return parentContact;
    }

    public void setParentContact(Contact parentContact) {
        this.parentContact = parentContact;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }




}
