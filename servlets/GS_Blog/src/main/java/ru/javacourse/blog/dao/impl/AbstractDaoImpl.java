package ru.javacourse.blog.dao.impl;

import ru.javacourse.blog.dao.AbstractDao;
import ru.javacourse.blog.model.BaseEntity;
import ru.javacourse.blog.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 21.04.13
 */
public abstract class  AbstractDaoImpl<T extends BaseEntity>  implements AbstractDao<T> {

    DatabaseUtil dbUtil = new DatabaseUtil();

    @Override
    public T create(T entity) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = dbUtil.getConnection();
            String query = getCreateQuery();
            pstmt = connection.prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);
            fillCreateStatement(pstmt, entity);
            pstmt.executeUpdate();

            resultSet = pstmt.getGeneratedKeys();
            if (resultSet.next()){
                Integer generatedId = resultSet.getInt(1);
                return getById(generatedId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)  try { resultSet.close(); } catch (SQLException logOrIgnore) {}
            if (pstmt != null)      try { pstmt.close(); } catch (SQLException logOrIgnore) {}
            if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
        }

        return null;
    }

    @Override
    public void delete(T entity) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dbUtil.getConnection();
            String query = getDeleteQuery();
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, entity.getId());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null)      try { pstmt.close(); } catch (SQLException logOrIgnore) {}
            if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
        }
    }

    @Override
    public T edit(T entity) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dbUtil.getConnection();
            String query = getEditQuery();
            pstmt = connection.prepareStatement(query);
            fillEditStatement(pstmt, entity);
            pstmt.executeUpdate();
            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null)      try { pstmt.close(); } catch (SQLException logOrIgnore) {}
            if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
        }

        return null;
    }

    @Override
    public T getById(Integer id) {

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = dbUtil.getConnection();
            String query = getGetByIdQuery();
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()){
                return getEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)  try { resultSet.close(); } catch (SQLException logOrIgnore) {}
            if (pstmt != null)      try { pstmt.close(); } catch (SQLException logOrIgnore) {}
            if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
        }
        return null;
    }

    @Override
    public List<T> getAll() {

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        List<T> list = new ArrayList<T>();
        try {
            connection = dbUtil.getConnection();
            String query = getGetAllQuery();
            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                list.add(getEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)  try { resultSet.close(); } catch (SQLException logOrIgnore) {}
            if (pstmt != null)      try { pstmt.close(); } catch (SQLException logOrIgnore) {}
            if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
        }
        return list;
    }

    public abstract void fillCreateStatement(PreparedStatement pstmt, T entity);
    public abstract void fillEditStatement(PreparedStatement pstmt, T entity);
    public abstract T getEntity(ResultSet resultSet);


    public abstract String getCreateQuery();
    public abstract String getDeleteQuery();
    public abstract String getEditQuery();
    public abstract String getGetByIdQuery();
    public abstract String getGetAllQuery();
}
