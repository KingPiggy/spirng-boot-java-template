package com.kingpiggy.app.persistence.repository;

import com.kingpiggy.app.persistence.dto.SampleDto;

import java.util.List;

public interface SampleRepositoryCustom {

    List<SampleDto> findAllData();

}
