package ru.javacourse.blog.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author: Georgy Gobozov
 * Date: 21.04.13
 */
public class Post extends BaseEntity{


    private String title;
    private String summary;
    private String body;
    private Category category;

    public Post() {
    }

    public Post(String title, String summary, String body, Category category) {
        this.title = title;
        this.summary = summary;
        this.body = body;
        this.category = category;
    }

    public Post(ResultSet resultSet, Category category) throws SQLException{
        this.id = resultSet.getInt("id");
        this.title = resultSet.getString("title");
        this.summary = resultSet.getString("summary");
        this.body = resultSet.getString("body");
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
