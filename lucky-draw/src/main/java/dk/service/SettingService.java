package dk.service;

import dk.exception.BusinessException;
import dk.mapper.MemberMapper;
import dk.mapper.SettingMapper;
import dk.model.Award;
import dk.model.Member;
import dk.model.Setting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SettingService {

    @Autowired
    private SettingMapper settingMapper;

    // 在设计层面这里注入Service,也可以注入Mapper
    @Autowired
    private AwardService awardService;

    @Autowired
    private MemberService memberService;

    @Transactional
    public Setting query(Integer id) {
        Setting query = new Setting();
        query.setUserId(id);
        //注册用户时,需要生成一个Setting数据,1对1,如果没有生成,业务有问题
        Setting setting = settingMapper.selectOne(query);
        if (setting == null)
            throw new BusinessException("SET001", "用户设置信息出错");

        //添加查询奖品列表:通过setting_id查询
        Award award = new Award();
        award.setSettingId(setting.getId());
        List<Award> awards = awardService.query(award);
        setting.setAwards(awards);
        //添加查询抽奖人员列表:通过user_id查询
        Member member = new Member();
        member.setUserId(id);
        List<Member> members = memberService.query(member);
        setting.setMembers(members);

        return setting;
    }

    @Transactional
    public void add(Setting setting) { //添加用户信息
        settingMapper.insertSelective(setting);
    }

    //Spring事务设置: 默认的传播方式为Required,当前没有事务就创建,有就加入
    @Transactional
    public void update(Integer id, Integer batchNumber) {
        //第一种实现: 可以使用mapper已提供的单表操作方法: 根据userid查询setting信息,再修改.(总共两步)
        //第二种实现: 自己写sql,一次性修改.(总共一步)
        //我们使用第二种方式:
        int num=settingMapper.updateByUserId(id,batchNumber);
    }
}
