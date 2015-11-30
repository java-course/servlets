package ru.javacourse.blog.dao.impl;

import ru.javacourse.blog.model.Comment;
import ru.javacourse.blog.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgy Gobozov on 11/30/2015.
 */
public class CommentDao {

    DatabaseUtil dbUtil = new DatabaseUtil();
    PostDao postDao = new PostDao();

    public void create(Comment comment) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        //ResultSet resultSet = null;
        try {
            connection = dbUtil.getConnection();
            String query = "insert into comments (text, postId) values (?,?)";
            pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, comment.getText());
            pstmt.setInt(2, comment.getPost().getId());
            pstmt.executeUpdate();

//                resultSet = pstmt.getGeneratedKeys();
//                if (resultSet.next()){
//                    Integer generatedId = resultSet.getInt(1);
//                    return getById(generatedId);
//                }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //if (resultSet != null)  try { resultSet.close(); } catch (SQLException logOrIgnore) {}
            if (pstmt != null) try {
                pstmt.close();
            } catch (SQLException logOrIgnore) {
            }
            if (connection != null) try {
                connection.close();
            } catch (SQLException logOrIgnore) {
            }
        }
    }


    public List<Comment> getCommentsByPostId(int postId){

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        List<Comment> comments = new ArrayList<>();
        try {
            connection = dbUtil.getConnection();
            String query = "SELECT * FROM comments WHERE postId = ?";
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, postId);
            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                //return getEntity(resultSet);
                Comment comment = new Comment();
                comment.setId(resultSet.getInt("id"));
                comment.setText(resultSet.getString("text"));
                comment.setPost(postDao.getById(postId));
                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)  try { resultSet.close(); } catch (SQLException logOrIgnore) {}
            if (pstmt != null)      try { pstmt.close(); } catch (SQLException logOrIgnore) {}
            if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
        }

        return comments;

    }


}
