package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wuting
 * @date 2020/02/02
 */
@WebServlet("/demo")
public class TomcatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String param = req.getParameter("msg");
        resp.getWriter().print(param);
        resp.getWriter().print("##################");
    }

}
