package dk.mapper;

import org.apache.ibatis.annotations.Mapper;
import dk.base.BaseMapper;
import dk.model.Setting;

@Mapper
public interface SettingMapper extends BaseMapper<Setting> {
}