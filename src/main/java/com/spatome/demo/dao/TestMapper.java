package com.spatome.demo.dao;

import java.util.List;

import com.spatome.demo.entity.Test;

public interface TestMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);


    List<Test> selectByBean(Test record);
}