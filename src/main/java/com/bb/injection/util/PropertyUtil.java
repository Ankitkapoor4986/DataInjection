package com.bb.injection.util;

import com.bb.injection.properties.PropertyGetter;

/**
 * Created by ankit on 31/5/16.
 */
public class PropertyUtil {

    public static final String INSERT_USER ="insert_user";
    public static final String UPDATE_ADDRESS ="update_address";
    public static final  String ADDRESS_USER_COUNT_KEY="address_user_count";
    public static final  String GOOGLE_API ="api";


    public static String getProperty(String key){
        return PropertyGetter.getInstance().getProperty(key).get() ;
    }
}
