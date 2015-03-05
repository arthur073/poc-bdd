import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by s819578 on 04/03/2015.
 */
public class FileUtil {

    private static Properties properties;

    private static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(fileName));
            return properties;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getProperty(String propertyName) {
        properties = loadProperties("src/config.properties");
        return properties.getProperty(propertyName);
    }
}
