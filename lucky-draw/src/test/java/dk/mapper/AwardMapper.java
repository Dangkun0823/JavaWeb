package dk.mapper;

import org.apache.ibatis.annotations.Mapper;
import dk.base.BaseMapper;
import dk.model.Award;

@Mapper
public interface AwardMapper extends BaseMapper<Award> {
}