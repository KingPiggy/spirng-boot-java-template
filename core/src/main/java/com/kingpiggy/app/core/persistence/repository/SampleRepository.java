package com.kingpiggy.app.core.persistence.repository;

import com.kingpiggy.app.core.persistence.entity.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRepository extends JpaRepository<SampleEntity, Long>, SampleRepositoryCustom {

    List<SampleEntity> findAll();

}