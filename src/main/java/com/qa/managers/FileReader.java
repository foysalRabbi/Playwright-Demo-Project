package com.qa.managers;

import com.qa.utilities.ConfigReader;

public class FileReader {
    private static final FileReader fileReader= new FileReader();
    private static ConfigReader configReader;

    private FileReader() {

    }
    public static FileReader getInstance() {

        return fileReader;
    }

    public static void setConfigReader(ConfigReader configReader) {
        FileReader.configReader = configReader;
    }

    public ConfigReader getConfigReader() {
        return (configReader == null) ? new ConfigReader() : configReader;
    }
}
