package com.easytrade.easytradelib;

import java.io.File;
import java.nio.file.Files;

/**
 * Created by Sofy on 1/25/2017.
 */
public class TestUtills {
    public static String getJSONFromFile(String fileName) throws Exception {
        ClassLoader classLoader = new TestUtills().getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        return new String(Files.readAllBytes(file.toPath()));
    }
}
