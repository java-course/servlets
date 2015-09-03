package ru.javacourse.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Georgy Gobozov on 9/3/2015.
 */
@WebServlet(urlPatterns = "/apacheUplaod")
public class ApacheFileUploadServlet extends HttpServlet {

    String dest = null;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        dest = request.getParameter("destination");
        System.out.println("dest = " + dest);

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Parse the request
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        // Process the uploaded items
        Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = iter.next();

            if (item.isFormField()) {

                System.out.println("Filed  + " + item.getFieldName() + " VAlue = " + item.getString());

            } else {

                File disk = new File("C:\\temp\\files" + File.separator + item.getName());
                try {
                    item.write(disk);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
