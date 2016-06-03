package com.bb.injection.model;

/**
 * Created by ankit on 26/5/16.
 */
public class Country {
    private long CountryId;
    private String name;
    private String a2;
    private String a3;
    private String number;
    private String idd;
    private boolean active;


    @Override
    public String toString() {
        return "Country{" +
                "CountryId=" + CountryId +
                ", name='" + name + '\'' +
                ", a2='" + a2 + '\'' +
                ", a3='" + a3 + '\'' +
                ", number='" + number + '\'' +
                ", idd='" + idd + '\'' +
                ", active=" + active +
                '}';
    }

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getCountryId() {
        return CountryId;
    }

    public void setCountryId(long countryId) {
        CountryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
