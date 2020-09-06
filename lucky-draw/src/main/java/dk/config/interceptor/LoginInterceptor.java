package dk.config.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import dk.base.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {

    private ObjectMapper objectMapper; //ObjectMapper 类是jackson库的主要类.
    // 提供一些功能将转换成Java对象匹配JSON对象, 或是将JSON对象转换为Java对象.

    public LoginInterceptor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * if(session!=null && session.getAttribute("user") !=null
     * return true; => 继续执行
     * else 返回一个带错误码和错误信息的json
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            return true;//如果已登录,继续执行Controller中的方法
        }

        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);//这里是浏览器用来解析的数据格式和编码
        response.setCharacterEncoding("UTF-8");//这里和java文件的编码一致,设置响应体编码

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        //前端通过状态码已经处理了,可以不返回响应体内容,下面的可写可不写
        ResponseResult r = ResponseResult.error("SES000","用户没有登录");
        PrintWriter pw=response.getWriter();
        pw.println(objectMapper.writeValueAsString(r));//序列化为json对象
        pw.flush();
        return false;
    }
}
