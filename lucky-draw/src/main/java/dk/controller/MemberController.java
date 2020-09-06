package dk.controller;

import dk.model.Member;
import dk.model.User;
import dk.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/add")
    public Object add(@RequestBody Member member,HttpSession session) {
        User user=(User) session.getAttribute("user");
        member.setUserId(user.getSettingId()); //抽奖人员设置好用户id
        memberService.add(member);
        return member.getId(); //同时返回抽奖人员id
    }

    @PostMapping("/update")
    public Object update(@RequestBody Member member){
        memberService.update(member);
        return null;
    }

    @GetMapping("/delete/{id}")
    //其中 {id}和id 必须一样
    public Object delete(@PathVariable Integer id){
        memberService.delete(id);
        return null;
    }
}
