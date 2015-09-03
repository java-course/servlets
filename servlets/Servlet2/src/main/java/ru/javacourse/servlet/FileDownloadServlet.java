package ru.javacourse.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.nio.file.Files;

/**
 * Created by Georgy Gobozov on 9/3/2015.
 */
@WebServlet(urlPatterns = "/download")
public class FileDownloadServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String path = request.getParameter("path");
        File file = new File(path);

        if (file.exists()) {

            OutputStream out = response.getOutputStream();
            InputStream filecontent = new FileInputStream(file);


            try {


                int read = 0;
                final byte[] bytes = new byte[1024];

                while ((read = filecontent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                response.setContentType(getMimeType(file.getName()));
                response.setHeader("Content-Disposition",
                        "attachment;filename=\""  + file.getName() + "\"");


            } catch (FileNotFoundException fne) {
                fne.printStackTrace();


            } finally {
                if (out != null) {
                    out.close();
                }
                if (filecontent != null) {
                    filecontent.close();
                }

            }




        }else {

            response.getWriter().write("File by path " + path + " does not exists");
            response.getWriter().close();
        }



    }

    private static String getMimeType(String filename) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String mimeType = fileNameMap.getContentTypeFor(filename);
        return mimeType;
    }
}
