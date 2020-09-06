package dk.mapper;

import org.apache.ibatis.annotations.Mapper;
import dk.base.BaseMapper;
import dk.model.Member;

@Mapper
public interface MemberMapper extends BaseMapper<Member> {
}