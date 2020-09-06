package dk.mapper;

import org.apache.ibatis.annotations.Mapper;
import dk.base.BaseMapper;
import dk.model.Record;

@Mapper
public interface RecordMapper extends BaseMapper<Record> {
}