package dk.service;

import dk.mapper.AwardMapper;
import dk.model.Award;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AwardService {

    @Autowired
    private AwardMapper awardMapper;

    //因为Award里面有一个自己定义的字段,而不是 原生 的字段,
    //所以我们要 自己写一个查询方法,同时去对应xml文件里面写方法
    public List<Award> query(Award award) {
        return awardMapper.query(award);
    }

    //方法1:session获取user,通过userid查询setting id,再设置插入到award对象中
    //方法2:登录时,setting信息设置到会话中
    @Transactional
    public void add(Award award) {
        awardMapper.insertSelective(award);//有选择的新增一个奖项.
    }

    @Transactional
    public void update(Award award) {
        awardMapper.updateByPrimaryKeySelective(award);//根据奖项主键有选择性的进行 修改奖项属性
    }

    @Transactional
    public void delete(Integer id) {
        awardMapper.deleteByPrimaryKey(id);//根据主键 删除
    }
}
