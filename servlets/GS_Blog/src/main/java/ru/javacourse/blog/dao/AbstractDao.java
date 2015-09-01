package ru.javacourse.blog.dao;

import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 21.04.13
 */
public interface AbstractDao<T> {

    public T create(T entity);
    public void delete(T entity);
    public T edit (T entity);
    public T getById(Integer id);
    public List<T> getAll();

}
