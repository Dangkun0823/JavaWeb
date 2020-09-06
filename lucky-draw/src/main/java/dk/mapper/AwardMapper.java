package dk.mapper;

import org.apache.ibatis.annotations.Mapper;
import dk.base.BaseMapper;
import dk.model.Award;

import java.util.List;


@Mapper
public interface AwardMapper extends BaseMapper<Award> {

    //生成接口方法,然后配置xml文件里的方法
    List<Award> query(Award award);
}