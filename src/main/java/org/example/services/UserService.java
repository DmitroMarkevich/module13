package org.example.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.example.entities.user.User;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class UserService {
    private static final Gson gson = new GsonBuilder().create();
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
    public static User createUser(User user) throws IOException {
        String requestBody = gson.toJson(user);

        HttpResponse response = Request.Post(BASE_URL)
                .bodyString(requestBody, ContentType.APPLICATION_JSON)
                .execute()
                .returnResponse();

        return gson.fromJson(EntityUtils.toString(response.getEntity()), User.class);
    }
    public static User updateUser(User updatedUser) throws IOException {
        String requestBody = gson.toJson(updatedUser);

        HttpResponse response = Request.Put(BASE_URL + "/" + updatedUser.getId())
                .bodyString(requestBody, ContentType.APPLICATION_JSON)
                .execute()
                .returnResponse();

        System.out.println("Код: " + response.getStatusLine().getStatusCode());
        return gson.fromJson(EntityUtils.toString(response.getEntity()), User.class);
    }
    public static User deleteUser(int id) throws IOException {
        HttpResponse response = Request.Delete(BASE_URL + "/" + id)
                .execute()
                .returnResponse();

        System.out.println("Код: " + response.getStatusLine().getStatusCode());
        return gson.fromJson(EntityUtils.toString(response.getEntity()), User.class);
    }
    public static List<User> getAllUsers() throws IOException {
        String userJson = Jsoup.connect(BASE_URL)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Type typeToken = TypeToken
                .getParameterized(List.class, User.class)
                .getType();

        return gson.fromJson(userJson, typeToken);
    }
    public static User getUserById(int id) throws IOException {
        String userJson = Jsoup.connect(BASE_URL)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Type typeToken = TypeToken
                .getParameterized(List.class, User.class)
                .getType();

        List<User> users = gson.fromJson(userJson, typeToken);

        return users.stream()
                .filter(userId -> userId.getId() == id)
                .findFirst()
                .orElseThrow();
    }
    public static User getUserByUsername(String username) throws IOException {
        String userJson = Jsoup.connect(BASE_URL)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Type typeToken = TypeToken
                .getParameterized(List.class, User.class)
                .getType();

        List<User> users = gson.fromJson(userJson, typeToken);

        return users.stream()
                .filter(userId -> userId.getUsername().equals(username))
                .findFirst()
                .orElseThrow();
    }
}
