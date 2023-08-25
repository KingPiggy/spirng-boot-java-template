package com.kingpiggy.app.core.persistence.repository;

import com.kingpiggy.app.core.persistence.dto.SampleDto;

import java.util.List;

public interface SampleRepositoryCustom {

    List<SampleDto> findAllData();

}
