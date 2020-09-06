package dk.controller;

import dk.model.Setting;
import dk.model.User;
import dk.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/setting")
public class SettingController { // 与抽奖的设置相关的信息

    @Autowired
    private SettingService settingService;

    /**
     * Cookie中携带tomcat的session信息,也就是请求头中包含Cookie:JSESSIONID=xxx
     * 比如服务器重启,或者没有登录但却携带JSESSIONID信息,获取的HttpSession对象就不为空
     * 如果 不实现拦截器, 就要保证以上逻辑
     * 如果 实现了拦截器, 就一定要登录了才允许访问接口
     */

    @GetMapping("/query") //类似于 servlet 的 doGet 方法
    public Object query(HttpSession session) { //查询奖品列表和抽奖人员列表
        //只有登陆后才能访问接口, 从会话中获取保存的用户信息.
        User user = (User) session.getAttribute("user");
        //进行query查询, 查询奖品列表和抽奖人员列表.
        Setting setting = settingService.query(user.getId());
        //然后返回信息, 同时设置信息给用户.
        setting.setUser(user);
        return setting;
    }

    //api/setting/update ? batchNumber=5
    @GetMapping("/update") //修改抽奖人数
    public Object update(Integer batchNumber, HttpSession session) { //两个参数,用户id和抽奖人数
        User user = (User) session.getAttribute("user");
        settingService.update(user.getId(), batchNumber);
        return null;
    }
}
