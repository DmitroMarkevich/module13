package org.example.services;

import java.io.IOException;

import org.apache.http.client.fluent.Request;
import org.example.services.utils.FileUtil;

public class CommentService {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static String findLastPostComments(int userId) throws IOException {
        int postId = userLastPostFind(userId);

        String commentsJson = Request.Get(BASE_URL + "/posts/" + postId + "/comments?userId=" + userId)
                .execute()
                .returnContent()
                .asString();

        FileUtil.saveCommentsToFile(commentsJson, userId, postId);
        return commentsJson;
    }
    private static int userLastPostFind(int userId) throws IOException {
        String responseBody = Request.Get(BASE_URL + "/users/" + userId + "/posts")
                .execute()
                .returnContent()
                .asString();

        int lastPostId = -1;
        for (String line : responseBody.split("\n")) {
            String[] parts = line.trim().split(",");
            for (String part : parts) {
                if (part.contains("\"id\":")) {
                    int postId = Integer.parseInt(part.trim().split(":")[1].trim());
                    if (postId > lastPostId) lastPostId = postId;
                    break;
                }
            }
        } return lastPostId;
    }
}