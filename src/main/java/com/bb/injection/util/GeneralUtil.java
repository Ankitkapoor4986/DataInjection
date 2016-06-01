package com.bb.injection.util;

import com.bb.injection.constants.Constants;

import java.util.Objects;

/**
 * Created by ankit on 1/6/16.
 */
public class GeneralUtil {

    public static String  spaceTOPercentageReplacer(String str){
        return str.replaceAll(Constants.SPACE, Constants.PERCENTAGE_20);

    }

    public static boolean isNotNullAndNotEmpity(String str){
        return ((Objects.nonNull(str))&&(!str.equals(Constants.EMPTY)));
    }
}
