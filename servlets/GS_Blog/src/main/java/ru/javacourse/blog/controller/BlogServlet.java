package ru.javacourse.blog.controller;

import ru.javacourse.blog.dao.impl.CategoryDao;
import ru.javacourse.blog.dao.impl.PostDao;
import ru.javacourse.blog.model.Category;
import ru.javacourse.blog.model.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Author: Georgy Gobozov
 * Date: 21.04.13
 */
public class BlogServlet extends HttpServlet {


    PostDao postDao = new PostDao();
    CategoryDao categoryDao = new CategoryDao();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", request.getLocale());

        response.setHeader("Content-Language", request.getLocale().getLanguage());

        String postId = request.getParameter("post");
        String categoryId = request.getParameter("category");
        String url = request.getRequestURL().toString();

        if (url.contains("newpost")) {
            List<Category> categories = categoryDao.getAll();
            request.setAttribute("categories", categories);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/newPost.jsp");
            rd.forward(request, response);
            return;
        }


        if (postId != null) {

            Post post = postDao.getById(Integer.parseInt(postId));
            request.setAttribute("post", post);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/post.jsp");
            rd.forward(request, response);


        }  else {

            List<Post> posts = categoryId == null ?
                    postDao.getAll() :
                    postDao.getPostsByCategoryId(Integer.parseInt(categoryId));

            List<Category> categories = categoryDao.getAll();

            request.setAttribute("posts", posts);
            request.setAttribute("categories", categories);
            request.setAttribute("test", resourceBundle.getString("test"));

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/index.jsp");
            rd.forward(request, response);

        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String summary = request.getParameter("summary");
        String body = request.getParameter("body");
        String category = request.getParameter("category");

        if (isValidPost(title, summary, body)){
            Category cat =  categoryDao.getById(Integer.parseInt(category));

            Post post = new Post(title, summary, body, cat);
            if (id != null) {
                post.setId(Integer.parseInt(id));
                postDao.edit(post);
            }else{
                postDao.create(post);
            }
            response.sendRedirect("/blog");
        }else {

            Post post = new Post();

            if (!isNullOrEmpty(title)) post.setTitle(title);
            if (!isNullOrEmpty(summary)) post.setSummary(summary);
            if (!isNullOrEmpty(body)) post.setBody(body);

            request.setAttribute("error", "Please fill required fields!");
            request.setAttribute("post", post);
            request.setAttribute("categories", categoryDao.getAll());
            getServletConfig().getServletContext().getRequestDispatcher("/jsp/newPost.jsp").
                    forward(request, response);

        }

    }

    private boolean isValidPost(String title, String summary, String body){
        if (isNullOrEmpty(title)) return false;
        if (isNullOrEmpty(summary)) return false;
        if (isNullOrEmpty(body)) return false;
        return true;
    }

    private boolean isNullOrEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

}
