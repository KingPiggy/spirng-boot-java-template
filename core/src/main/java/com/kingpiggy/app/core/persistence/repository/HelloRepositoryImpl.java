package com.kingpiggy.app.core.persistence.repository;

import com.kingpiggy.app.core.persistence.dto.HelloDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.kingpiggy.app.core.persistence.entity.QHelloEntity.helloEntity;

@RequiredArgsConstructor
public class HelloRepositoryImpl implements HelloRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<HelloDto> findAllData() {
        return queryFactory
                .select(Projections.fields(HelloDto.class,
                        helloEntity.id.as("id"),
                        helloEntity.title.as("title"),
                        helloEntity.description.as("description")
                ))
                .from(
                        helloEntity
                )
                .fetch();
    }

}
