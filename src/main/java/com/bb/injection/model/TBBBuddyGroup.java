package com.bb.injection.model;

/**
 * Created by ankit on 1/6/16.
 */
public class TBBBuddyGroup {
    private long buddyGroupId;
    private User user;
    private double lat;
    private double lng;
    private long groupId;

    public long getBuddyGroupId() {
        return buddyGroupId;
    }

    public void setBuddyGroupId(long buddyGroupId) {
        this.buddyGroupId = buddyGroupId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }




}
