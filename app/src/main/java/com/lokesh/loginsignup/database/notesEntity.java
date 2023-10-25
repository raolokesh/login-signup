package com.lokesh.loginsignup.database;

public class notesEntity {
    int id;

    String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String description;
    String date;
    String userId;


    public notesEntity(int id,String title, String description, String date, String userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
