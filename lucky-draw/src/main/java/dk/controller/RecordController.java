package dk.controller;

import dk.model.User;
import dk.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController { // 抽奖相关的

    @Autowired
    private RecordService recordService;

    //POST api/record/add/3
    //Content-Type: application/json
    //[92, 22, 43, 76]
    @PostMapping("/add/{awardId}") //以上路径中最后的数字代表奖项id，请求数据为抽奖人员id组成的数组
    public Object add(@PathVariable("awardId") Integer ad, @RequestBody List<Integer> memberIds){

        recordService.add(ad,memberIds);
        return null;
    }

    //我们的业务,一个人只能抽一次奖,可以直接根据 memberid删. 如果业务允许一个人抽多个奖===>通过 memberid+awardid删
    //GET  api/record/delete/member ? id=22
    @GetMapping("/delete/member") //删除当前奖项 某个获奖人员
    public Object deleteByMemberId(Integer id){
        recordService.deleteByMemberId(id);
        return null;
    }

    //GET  api/record/delete/award ?id=3
    @GetMapping("/delete/award") //删除当前奖项 已获奖人员
    public Object deleteByAwardId(Integer id){
        recordService.deleteByAwardId(id);
        return null;
    }

    //根据 setting_id删除中奖记录 (重置中奖,删除所有记录)
    @GetMapping("/delete/setting")
    public Object deleteBySettingId(HttpSession session){
        User user=(User)session.getAttribute("user");
        recordService.deleteBySettingId(user.getSettingId());
        return null;
    }
}
