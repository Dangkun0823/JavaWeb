package dk.base;

import java.util.List;

// Mapper的父类接口, 所有接口方法都是类似，只是传入参数和返回值不同.
// 设计统一的基类，以 泛型 的方式定义出不同的参数类型、返回类型
// mapper 都是接口,没有方法体,只有方法名
public interface BaseMapper <T extends BaseEntity> {

    T selectByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    int deleteByPrimaryKey(Integer id);

    T selectOne(T record);

    List<T> selectAll();

    List<T> selectByCondition(T record);

    int deleteByIds(List<Integer> ids);
}
