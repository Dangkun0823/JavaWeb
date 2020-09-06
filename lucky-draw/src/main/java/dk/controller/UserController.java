package dk.controller;

import dk.model.Setting;
import dk.model.User;
import dk.service.SettingService;
import dk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 调用层次: Controller => Service => Mapper
     */
    @Autowired
    private UserService userService;

    @Autowired
    private SettingService settingService;

    @PostMapping("/login")
    public Object login(@RequestBody User user, HttpServletRequest req) {
        //如果用户名密码校验失败,在service中抛异常, 这里的exist一定不为null
        User exist = userService.login(user);
        Setting setting = settingService.query(exist.getId());
        exist.setSettingId(setting.getId());
        HttpSession session = req.getSession();
        session.setAttribute("user", exist);//根据用户id,给用户设置setting_id,同时设置到用户session里.
        session.setAttribute("setting", setting);//把查询奖品和抽奖人员列表设置到Setting的session里.
        return null;
    }

    //注册功能
    @PostMapping("/register")
    public Object register(User user,
                           //头像可上传也可不上传
                           //上传的头像: 1. 保存在本地文件夹(web服务器可以加载到) 2.url存放在注册用户的head字段
                           @RequestPart(value = "headFile", required = false) MultipartFile headFile) {
        //没有做服务器请求数据的校验,实现方式:1.手动校验 2.使用validation框架校验(很多注解)
        //TODO
        userService.register(user, headFile);
        return null;
    }

    /**
     * 注销功能: get api/user/logout
     */
    @GetMapping("logout")
    public Object logout(HttpSession session) {
        //如果登录了,就删除登录信息,前端写了跳转到index.html
        if (session != null)
            session.removeAttribute("user");
        return null;
    }
}
