package dk.service;

import dk.mapper.RecordMapper;
import dk.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Transactional
    public void add(Integer awardId, List<Integer> memberIds) {
        /**
         * 批量更新:
         * 方法1.循环遍历后每次更新 ==> 简单暴力,不推荐
         * 方法2.mybatis批量更新(扩展) ==> 推荐做法,效率更高,麻烦一点
         * ===>提供 mapper自定义方法: 两个参数的注意事项 @Param
         * List遍历参考deleteByIds生成方法
         * xml中写insert.....select.....
         */
//        for (Integer memeberId : memberIds) {
//            Record record = new Record();
//            record.setMemberId(memeberId);
//            record.setAwardId(awardId);
//            recordMapper.insertSelective(record);
//        }
        recordMapper.batchAdd(awardId,memberIds);
    }

    @Transactional
    public void deleteByMemberId(Integer id) {
        Record r = new Record();
        r.setMemberId(id);
        recordMapper.deleteByCondition(r);
    }

    @Transactional
    public void deleteByAwardId(Integer id) {
        Record r = new Record();
        r.setAwardId(id);
        recordMapper.deleteByCondition(r);
    }

    @Transactional
    public void deleteBySettingId(Integer id) {
        recordMapper.deleteBySettingId(id);
    }
}
