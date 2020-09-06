package dk.config;

//import dk.config.interceptor.LoginInterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.config.interceptor.LoginInterceptor;
import dk.config.web.RequestResponseBodyMethodProcessorWrapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SysConfig implements WebMvcConfigurer, InitializingBean{

    //注入容器一个对象
    @Resource
    private RequestMappingHandlerAdapter adapter;

    //SpringMVC初始化操作时,就会注册的对象
    @Autowired
    private ObjectMapper objectMapper;

    // 和之前以@ControllerAdvice + 实现ResponseBodyAdvice接口,
    // 完成统一处理返回数据包装,: 无法解决返回值为null 需要包装
    // 改用现在这种方式, 可以解决自定义类 返回值为null这个问题
    @Override
    public void afterPropertiesSet() {
        List<HandlerMethodReturnValueHandler> returnValueHandlers = adapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList(returnValueHandlers);
        for(int i=0; i<handlers.size(); i++){
            HandlerMethodReturnValueHandler handler = handlers.get(i);
            if(handler instanceof RequestResponseBodyMethodProcessor){
                handlers.set(i, new RequestResponseBodyMethodProcessorWrapper(handler));
            }
        }
        adapter.setReturnValueHandlers(handlers);
    }

    //添加拦截器interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor(objectMapper))
                .addPathPatterns("/api/**") //**代表多级路径任意匹配, *代表一级路径匹配
                // 排除登录, 注册, 注销 这三个页面
                .excludePathPatterns("/api/user/login")
                .excludePathPatterns("/api/user/register")
                .excludePathPatterns("/api/user/logout");
        //TODO 再添加一个前端静态资源请求的拦截器,非登录页面(/*.html 排除/index.html), 如果没有登录,重定向到/index.html
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //Controller路径, 统一添加请求路径的前缀, 第二个参数,表示是否添加
        //也就是所有写 @Controller 请求路径, 都要带/api的前缀才能访问
        //以此来完成拦截请求资源,实现会话管理
        configurer.addPathPrefix("api",c->true);
    }
}


