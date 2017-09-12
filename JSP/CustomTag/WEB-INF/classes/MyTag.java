package my;
import javax.servlet.jsp.*;
import java.io.*;
import javax.servlet.jsp.tagext.*;
public class MyTag extends TagSupport
{
    JspWriter out;
    public int doStartTag() throws JspException
    {
        out=pageContext.getOut();
        try
        {
            out.print("Hello");
        }
        catch(Exception ex)
        {
            System.out.print(ex);
        }
        return SKIP_BODY;
    }
    public int doEndTag() throws JspException
    {
        try
        {
            int a=10,b=20;
            int c=a+b;
            System.out.print("sum="+c);
        }
        catch(Exception ex)
        {
            System.out.print(ex);
        }
        return EVAL_PAGE;
    }
}