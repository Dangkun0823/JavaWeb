package dk.controller;

import dk.model.Award;
import dk.model.User;
import dk.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/award")
public class AwardController {

    @Autowired
    private AwardService awardService;

    @PostMapping("/add") //新增奖项
    public Object add(@RequestBody Award award, HttpSession session) {//插入时,请求数据中不带id
        User user=(User) session.getAttribute("user");
        award.setSettingId(user.getSettingId()); //给奖项设置用户id.
        awardService.add(award); //添加一个奖项.
        return award.getId();//数据库插入时,会自动设置id为自增主键, 同时要返回给前端,否则有bug(与前端对应)
    }

    @PostMapping("/update") //修改奖项
    public Object update(@RequestBody Award award) {//修改时根据id修改
        awardService.update(award);
        return null;
    }

    //GET api/award/delete/4
    @GetMapping("/delete/{id}") //删除一个奖项
    public Object delete(@PathVariable Integer id) {
        //@PathVariable中的值绑定路径变量, 如果@PathVariable没有值, 绑定为变量名
        awardService.delete(id);
        return null;
    }
}
