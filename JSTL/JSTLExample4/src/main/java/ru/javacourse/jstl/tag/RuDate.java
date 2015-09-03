package ru.javacourse.jstl.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Georgy Gobozov on 8/31/2015.
 */
public class RuDate extends TagSupport {

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            out.print(df.format(new Date()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }



}
