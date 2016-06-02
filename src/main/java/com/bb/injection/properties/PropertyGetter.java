package com.bb.injection.properties;

import com.bb.injection.controller.App;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

/**
 * Created by ankit on 31/5/16.
 */
public class PropertyGetter {

    private static Properties prop;
    private static PropertyGetter propertyGetter = new PropertyGetter();

    private PropertyGetter() {
        prop = new Properties();
        try (InputStream input = new FileInputStream(App.PATH)) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    public Optional<String> getProperty(String property) {

        return Optional.ofNullable(prop.getProperty(property));
    }

    public static PropertyGetter getInstance() {
        return propertyGetter;
    }



}










