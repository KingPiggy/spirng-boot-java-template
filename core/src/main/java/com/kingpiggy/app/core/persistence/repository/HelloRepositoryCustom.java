package com.kingpiggy.app.core.persistence.repository;

import com.kingpiggy.app.core.persistence.dto.HelloDto;

import java.util.List;

public interface HelloRepositoryCustom {

    List<HelloDto> findAllData();

}
