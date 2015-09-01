package ru.javacourse.blog.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Author: Georgy Gobozov
 * Date: 21.04.13
 */
public class DatabaseUtil {


    Properties queries;

    public DatabaseUtil() {
        loadProperties();
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Context context = new InitialContext();
            Context initContext  = (Context )context.lookup("java:/comp/env");
            DataSource ds = (DataSource) initContext.lookup("jdbc/blog");
            connection = ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public String getQuery(String name){
        System.out.println("Get query  " + name);
        if (queries == null)
            loadProperties();
        String q = queries.getProperty(name);
        System.out.println("q = " + q);
        return q;


    }


    private void loadProperties(){
        InputStream is = null;
        try {
            is = getClass().getResourceAsStream("/queries.properties");
            queries = new Properties();
            queries.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
