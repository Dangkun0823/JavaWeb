package dk.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter pw=resp.getWriter();

        //测试用,演示http请求头,响应头,状态码
        //演示400和301/302/307 重定向以及转发
        //模拟方式: 请求http://localhost:8081/项目部署名/test?i=
        String i=req.getParameter("i");
        if("1".equals(i)){ //重定向
            resp.sendRedirect("index.html");
        }else if("2".equals(i)){ //转发
            req.getRequestDispatcher("index.html").forward(req,resp);
        }else { //如果是int,就正常返回,如果不是就返回400
            try {
                Integer.parseInt(i);
                //正常返回,能够解析为int
                pw.println("正确的数值"+i);
            } catch (NumberFormatException e) {
                //非int,返回400
                resp.setStatus(400);
                pw.println("非数值"+i);
            }
        }

        pw.flush();
    }
}
