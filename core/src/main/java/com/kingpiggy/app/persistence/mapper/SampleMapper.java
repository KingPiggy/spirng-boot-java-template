package com.kingpiggy.app.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {

    int countAll();

}
