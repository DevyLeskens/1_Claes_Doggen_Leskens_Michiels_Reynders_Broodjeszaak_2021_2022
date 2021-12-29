package model;

import java.io.*;
import java.util.Properties;

public class Settings {

    public static void setProperties(String format, String discount) {
        try (OutputStream output = new FileOutputStream("src/bestanden/properties.properties")) {
            Properties prop = new Properties();
            prop.setProperty("productFormatReader", format);
            prop.setProperty("preferredDiscountStrategy", discount);
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
    public static String getProductFormatReaderSettings() {
        try (InputStream input = new FileInputStream("src/bestanden/properties.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty("productFormatReader");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static String getPreferredDiscountStrategySettings() {
        try (InputStream input = new FileInputStream("src/bestanden/properties.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty("preferredDiscountStrategy");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
