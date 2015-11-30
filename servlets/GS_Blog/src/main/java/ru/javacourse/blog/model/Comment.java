package ru.javacourse.blog.model;

/**
 * Created by Georgy Gobozov on 11/30/2015.
 */
public class Comment extends BaseEntity {

    private String text;
    private Post post;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
