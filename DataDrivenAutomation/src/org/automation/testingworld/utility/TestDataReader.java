package org.automation.testingworld.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestDataReader {
	// Generic method to read test data from JSON and deserialize it to the specified type
    public static <T> T readTestData(String fileName, Class<T> clazz) throws IOException {
        // Build the path to the test data file
        String filePath = Paths.get(System.getProperty("user.dir"), "Json", fileName).toString();

        // Ensure the file exists
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("The test data file '" + fileName + "' was not found at " + filePath);
        }

        // Create ObjectMapper for deserialization
        ObjectMapper objectMapper = new ObjectMapper();

        // Read the file content and deserialize it into the target type
        return objectMapper.readValue(file, clazz);
    }

    // Alternative method to deserialize into generic types like Lists, Maps, etc.
//    public static <T> T readTestData(String fileName, TypeReference<T> typeReference) throws IOException {
//        // Build the path to the test data file
//        String filePath = Paths.get(System.getProperty("user.dir"), "Json", fileName).toString();
//
//        // Ensure the file exists
//        File file = new File(filePath);
//        if (!file.exists()) {
//            throw new IOException("The test data file '" + fileName + "' was not found at " + filePath);
//        }
//
//        // Create ObjectMapper for deserialization
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        // Read the file content and deserialize it into the specified generic type
//        return objectMapper.readValue(file, typeReference);
//    }
}


