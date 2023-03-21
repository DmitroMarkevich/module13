package org.example.services;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.entities.Task;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
    public static List<Task> getOpenTasks(int id) throws IOException {
        String taskJson = Jsoup.connect(BASE_URL + "/" + id + "/todos")
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Type typeToken = TypeToken
                .getParameterized(List.class, Task.class)
                .getType();

        List<Task> tasks = new GsonBuilder().create().fromJson(taskJson, typeToken);

        return tasks.stream()
                .filter(status -> !status.isCompleted())
                .collect(Collectors.toList());
    }
}
