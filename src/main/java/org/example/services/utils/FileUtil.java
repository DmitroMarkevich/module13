package org.example.services.utils;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    public static void saveCommentsToFile(String commentsJson, int userId, int postId) {
        String fileName = String.format("user-%d-post-%d-comments.json", userId, postId);

        try (FileOutputStream fos = new FileOutputStream(fileName)){
            fos.write(commentsJson.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
