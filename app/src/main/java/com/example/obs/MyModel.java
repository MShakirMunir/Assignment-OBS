package com.example.obs;

public class MyModel {

    String bookName;
    String className;
    String autherName;
    String description;
    String location;

    public MyModel(String bookName, String className, String autherName, String description, String location) {
        this.bookName = bookName;
        this.className = className;
        this.autherName = autherName;
        this.description = description;
        this.location = location;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAutherName() {
        return autherName;
    }

    public void setAutherName(String autherName) {
        this.autherName = autherName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
