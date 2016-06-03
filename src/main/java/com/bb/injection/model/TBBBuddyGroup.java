package com.bb.injection.model;

import com.bb.injection.constants.Constants;

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

    public String getInsert(){

        return new StringBuilder("Insert into TBB_Buddy_Group (userId,LAT,LNG,groupId)")
                .append("values ").append(Constants.OPEN_BRACKET)
                .append(Constants.SINGLE_COTE).append(user.getUserId()).append(Constants.SINGLE_COTE).append(Constants.COMMA)
                .append(Constants.SINGLE_COTE).append(getLat()).append(Constants.SINGLE_COTE).append(Constants.COMMA)
                .append(Constants.SINGLE_COTE).append(getLng()).append(Constants.SINGLE_COTE).append(Constants.COMMA)
                .append(Constants.SINGLE_COTE).append(getGroupId()).append(Constants.SINGLE_COTE)
                .append(Constants.CLOSE_BRACKET)
                .toString();
    }




}
