package ru.javacourse.blog.controller;

import ru.javacourse.blog.dao.AbstractDao;
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

/**
 * Author: Georgy Gobozov
 * Date: 21.04.13
 */
public class BlogAdminServlet extends HttpServlet {

    AbstractDao<Post> postDao = new PostDao();
    AbstractDao<Category> categoryDao = new CategoryDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mode = request.getParameter("mode");

        if ("posts".equals(mode)) {
            List<Post> posts = postDao.getAll();
            request.setAttribute("posts", posts);
            List<Category> categories = categoryDao.getAll();
            request.setAttribute("categories", categories);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/admin/posts.jsp");
            rd.forward(request, response);
            return;
        }

        if ("categories".equals(mode)) {
            List<Category> categories = categoryDao.getAll();
            request.setAttribute("categories", categories);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/admin/categories.jsp");
            rd.forward(request, response);
            return;
        }

        String action = request.getParameter("action");
        String postId = request.getParameter("post");
        String categoryId = request.getParameter("category");

        if ("edit".equals(action)) {
            String target = "/jsp/newPost.jsp";
            if (postId != null) {
                Post post = postDao.getById(Integer.parseInt(postId));
                List<Category> categories = categoryDao.getAll();
                request.setAttribute("categories", categories);
                request.setAttribute("post", post);
            }
            if (categoryId != null) {
                target = "/jsp/admin/categories.jsp";
                Category category = categoryDao.getById(Integer.parseInt(categoryId));
                request.setAttribute("category", category);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
            rd.forward(request, response);
            return;
        }

        if ("delete".equals(action)) {

            if (postId != null) {
                Post post = postDao.getById(Integer.parseInt(postId));
                if (post != null)
                    postDao.delete(post);
                response.sendRedirect("/admin?mode=posts");
                return;
            }

            if (categoryId != null) {
                Category category = categoryDao.getById(Integer.parseInt(categoryId));
                if (category != null)
                    categoryDao.delete(category);

                response.sendRedirect("/admin?mode=categories");
                return;
            }

        }



        // forward to main admin page
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/admin/index.jsp");
        rd.forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String id = request.getParameter("id");

        if (name != null) {
            Category category = new Category(name);
            // edit action
            if (id != null){
                category.setId(Integer.parseInt(id));
                categoryDao.edit(category);
            }
            else{
                // create new category
                categoryDao.create(category);
            }

        }
        response.sendRedirect("/admin?mode=categories");

    }
}
