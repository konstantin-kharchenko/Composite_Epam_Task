package by.kharchenko.text.reader;

import by.kharchenko.text.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CustomFileReader {
    private static final Logger LOGGER = LogManager.getLogger(CustomFileReader.class);

    private static CustomFileReader instance;

    private CustomFileReader() {
    }

    public static CustomFileReader getInstance() {
        if (instance == null) {
            instance = new CustomFileReader();
        }
        return instance;
    }

    public String read(String path) throws CustomException, IOException {
        String value = "";
        ClassLoader classLoader = CustomFileReader.class.getClassLoader();
        try (
                InputStream inputStream = classLoader.getResourceAsStream(path);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(" ");
            }
            value = stringBuilder.toString().trim();
        }
        return value;
    }
}
