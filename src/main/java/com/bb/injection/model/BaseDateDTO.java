package com.bb.injection.model;

import java.time.LocalDateTime;

/**
 * Created by ankit on 26/5/16.
 */
public class BaseDateDTO {
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
