package com.kingpiggy.app.core.persistence.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {

    int countAll();

}
