package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

    public static String readProperty(String prop_) {
        Properties prop = new Properties();
        String dir = System.getProperty("user.dir");
        {
            try {
                InputStream input = new FileInputStream(dir+"\\src\\test\\java\\config\\config.properties");
                prop.load(input);


            } catch (Exception e) {
                e.printStackTrace();
            }
            return prop.getProperty(prop_);
        }
    }
}

