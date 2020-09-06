package dk.mapper;

import org.apache.ibatis.annotations.Mapper;
import dk.base.BaseMapper;
import dk.model.Record;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecordMapper extends BaseMapper<Record> {

    void deleteByCondition(Record r);

    int deleteBySettingId(Integer id);

    int batchAdd(@Param("awardId") Integer awardId, @Param("memberIds")
            List<Integer> memberIds);
}