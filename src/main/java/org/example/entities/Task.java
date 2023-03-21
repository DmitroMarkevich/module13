package org.example.entities;

public class Task {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public Task(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return "\nTask{" +
                "\n   \"userId\": " + userId +
                "\n   \"id\": " + id +
                "\n   \"title\": " + title +
                "\n   \"completed\": " + completed +
                "\n}";
    }
}
