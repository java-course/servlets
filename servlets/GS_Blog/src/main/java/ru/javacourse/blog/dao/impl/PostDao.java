package ru.javacourse.blog.dao.impl;

import ru.javacourse.blog.model.Category;
import ru.javacourse.blog.model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 21.04.13
 */
public class PostDao extends AbstractDaoImpl<Post> {

    @Override
    public void fillCreateStatement(PreparedStatement pstmt, Post entity) {
        try {
            pstmt.setString(1, entity.getTitle());
            pstmt.setString(2, entity.getSummary());
            pstmt.setString(3, entity.getBody());
            pstmt.setInt(4, entity.getCategory().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fillEditStatement(PreparedStatement pstmt, Post entity) {
        try {
            pstmt.setString(1, entity.getTitle());
            pstmt.setString(2, entity.getSummary());
            pstmt.setString(3, entity.getBody());
            pstmt.setInt(4, entity.getCategory().getId());
            pstmt.setInt(5, entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private CategoryDao categoryDao = new CategoryDao();

    @Override
    public Post getEntity(ResultSet resultSet) {
        try {
            Integer category_id = resultSet.getInt("categoryId");
            Category category = categoryDao.getById(category_id);
            return new Post(resultSet, category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    // java 7 style, no need to close resources manually (try with resources)
    public List<Post> getPostsByCategoryId(Integer categoryId) {
        List<Post> posts = new ArrayList<Post>();
        Category category = categoryDao.getById(categoryId);
        try (Connection connection = dbUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM posts WHERE categoryId=?");) {

            pstmt.setInt(1, categoryId);
            try (ResultSet resultSet = pstmt.executeQuery();){
                while (resultSet.next()){
                    posts.add(new Post(resultSet, category));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;


    }

    @Override
    public String getCreateQuery() {
        return dbUtil.getQuery("create.post");
    }

    @Override
    public String getDeleteQuery() {
        return dbUtil.getQuery("delete.post.by.id");
    }

    @Override
    public String getEditQuery() {
        return dbUtil.getQuery("update.post");
    }

    @Override
    public String getGetByIdQuery() {
        return dbUtil.getQuery("get.post.by.id");
    }

    @Override
    public String getGetAllQuery() {
        return dbUtil.getQuery("get.all.posts");
    }
}
