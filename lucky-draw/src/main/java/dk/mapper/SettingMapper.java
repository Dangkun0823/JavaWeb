package dk.mapper;

import org.apache.ibatis.annotations.Mapper;
import dk.base.BaseMapper;
import dk.model.Setting;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SettingMapper extends BaseMapper<Setting> {

    //mybatis传入参数有 多个 的时候,需要使用 @param并指定名称
    //xml 中使用的是 @Param里面的值为变量
    int updateByUserId(@Param("userId") Integer id, @Param("batchNumber") Integer batchNumber);
}