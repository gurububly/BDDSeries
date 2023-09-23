package utilities;

import constants.FrameworkConstants;
import enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertyUtils {


    private PropertyUtils() {

    }


    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
            try {
                properties.load(fis);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public static String getProperty(ConfigProperties key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(properties.getProperty(key.name().toLowerCase()))) {
            throw new Exception("Property name " + key + " is not found. please check config.properties file");
        }
        return properties.getProperty(key.name().toLowerCase()).trim();
    }
}
