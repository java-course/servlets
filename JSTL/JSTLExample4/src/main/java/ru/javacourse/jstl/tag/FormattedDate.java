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
public class FormattedDate extends TagSupport {

    private String format;


    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            DateFormat df = new SimpleDateFormat(format);
            out.print(df.format(new Date()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
