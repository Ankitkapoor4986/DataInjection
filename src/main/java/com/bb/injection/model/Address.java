package com.bb.injection.model;

import com.bb.injection.constants.Constants;
import com.bb.injection.util.GeneralUtil;
import com.bb.injection.util.PropertyUtil;

/**
 * Created by ankit on 25/5/16.
 */
public class Address extends BaseDateDTO{

    public static final String GOOGLE_API_STR = PropertyUtil.getProperty(PropertyUtil.GOOGLE_API);
    private long addressId;
    private User user;

    private String Street1;
    private String Street2;
    private String Street3;
    private String city;
    private String zip;
    private Region region;


    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public String getStreet1() {
        return Street1;
    }

    public void setStreet1(String street1) {
        Street1 = street1;
    }

    public String getStreet2() {
        return Street2;
    }

    public void setStreet2(String street2) {
        Street2 = street2;
    }

    public String getStreet3() {
        return Street3;
    }

    public void setStreet3(String street3) {
        Street3 = street3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }


    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", user=" + user +
                ", Street1='" + Street1 + '\'' +
                ", Street2='" + Street2 + '\'' +
                ", Street3='" + Street3 + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", region=" + region +
                '}';
    }

    public String getApiStrFromLocation() {

        StringBuilder addressStr = new StringBuilder(GOOGLE_API_STR);

        if (GeneralUtil.isNotNullAndNotEmpity(this.getStreet1())) {
            addressStr.append(
                    GeneralUtil.spaceTOPercentageReplacer(this
                            .getStreet1())).append(Constants.COMMA);
        }
        if (GeneralUtil.isNotNullAndNotEmpity(this.getStreet2())) {
            addressStr.append(
                    GeneralUtil.spaceTOPercentageReplacer(this
                            .getStreet2())).append(Constants.COMMA);
        }
        if (GeneralUtil.isNotNullAndNotEmpity(this.getCity())) {
            addressStr.append(
                    GeneralUtil.spaceTOPercentageReplacer(this
                            .getCity())).append(Constants.COMMA);
        }
        if (GeneralUtil.isNotNullAndNotEmpity(this.getRegion()
                .getName())) {
            addressStr.append(
                    GeneralUtil.spaceTOPercentageReplacer(this
                            .getRegion().getName())).append(
                    Constants.COMMA);
        }
        if (GeneralUtil.isNotNullAndNotEmpity(this.getRegion()
                .getCountry().getName())) {
            addressStr.append(
                    GeneralUtil.spaceTOPercentageReplacer(this
                            .getRegion().getCountry().getName())).append(
                    Constants.COMMA);
        }
        if (GeneralUtil.isNotNullAndNotEmpity(this.getZip())) {
            addressStr.append(GeneralUtil.spaceTOPercentageReplacer(this
                    .getZip()));
        }


        return addressStr.toString();



    }


}
