package com.kingpiggy.app.core.persistence.repository;

import com.kingpiggy.app.core.persistence.entity.HelloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HelloRepository extends JpaRepository<HelloEntity, Long>, HelloRepositoryCustom {

    List<HelloEntity> findAll();

}
