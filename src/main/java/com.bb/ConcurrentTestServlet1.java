package com.bb;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ConcurrentTestServlet1 extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String  username;
        response.setContentType("text/html;charset=gb2312");
        username = request.getParameter("username");
        PrintWriter output = response.getWriter();
        try {
            //为了突出并发问题，在这设置一个延时
            Thread.sleep(500);
            output.println("用户名:"+username+"<BR>");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


