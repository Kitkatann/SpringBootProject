package com.software.institute.kathb.springbootdemo;

public class Film {
    private int id;
    private String title;
    private String description;

    public Film(int id, String title, String description)
    {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\"= \"" + id +
                "\", \"title\"=\"" + title +
                "\", \"description\"=\"" + description +
                "\"}";
    }
}
