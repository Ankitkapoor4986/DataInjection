package com.bb.injection.model;

/**
 * Created by ankit on 26/5/16.
 */
public class Region {
    private long regionId;
    private Country country;
    private String regionCode;

    @Override
    public String toString() {
        return "Region{" +
                "regionId=" + regionId +
                ", country=" + country +
                ", regionCode='" + regionCode + '\'' +
                ", name='" + name + '\'' +
                ", active=" + active +
                '}';
    }

    private String name;
    private boolean active;

    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
