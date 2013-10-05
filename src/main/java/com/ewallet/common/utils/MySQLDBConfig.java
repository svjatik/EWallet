package com.ewallet.common.utils;

import java.util.ResourceBundle;

/**
 * User: Svjatoslav Glushchenko
 * Date: 10/5/13
 */
public class MySQLDBConfig {
    private static MySQLDBConfig instance;
    private ResourceBundle resource;
    private static final String BUNDLE_NAME = "db.mysql";
    public static final String DB_NAME = "DB_NAME";
    public static final String HOST = "HOST";
    public static final String DB_USER = "DB_USER";
    public static final String DB_PASS = "DB_PASS";
    public static final String UTF_8 = "UTF_8";

    public static MySQLDBConfig getInstance() {
        if (instance == null) {
            instance = new MySQLDBConfig();
            instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String) resource.getObject(key);
    }
}
