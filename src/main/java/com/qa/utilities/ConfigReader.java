package com.qa.utilities;
import java.io.*;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;

    public Properties browserInitialization() {
        prop = new Properties();
        String browser = System.getProperty("browser", "chrome");
        String browserFilePath = "./src/test/resources/configuration/browser/" + browser + ".properties";

        try {
            FileInputStream ip = new FileInputStream(browserFilePath);
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public ConfigReader() {
        String _environment = System.getProperty("env", "local");
        String envFilePath = "./src/test/resources/configuration/environments/" + _environment + ".properties";

        BufferedReader env;
        try {
            env = new BufferedReader(new FileReader(envFilePath));
            prop = new Properties();
            try {
                prop.load(env);
                env.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(_environment + " environment config properties not found " + envFilePath);
        }
    }

    public String getBaseUrl() {
        String url = prop.getProperty("nop_url");
        return url != null? url : "Application URL not specified in the properties file for the Key:url";
//        if (url != null) return url;
//        else
//            throw new RuntimeException("Application Url not specified in the properties file for the Key:url");
    }
}
