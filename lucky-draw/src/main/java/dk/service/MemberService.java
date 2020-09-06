package dk.service;

import dk.mapper.MemberMapper;
import dk.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public List<Member> query(Member member) {
        //selectByCondition 是xml里面提供原生的sql查询方法,是根据非主键的字段去条件查询
        return memberMapper.selectByCondition(member);
    }

    @Transactional
    public void add(Member member) {
        memberMapper.insertSelective(member);//有选择的进行插入
    }

    @Transactional
    public void update(Member member) {
        memberMapper.updateByPrimaryKeySelective(member);//根据主键有选择的进行删除
    }

    @Transactional
    public void delete(Integer id) {
        memberMapper.deleteByPrimaryKey(id);//根据主键删除
    }
}
