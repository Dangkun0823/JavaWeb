package dk.mapper;

import org.apache.ibatis.annotations.Mapper;
import dk.base.BaseMapper;
import dk.model.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}