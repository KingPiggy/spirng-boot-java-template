package com.kingpiggy.app.core.persistence.repository;

import com.kingpiggy.app.core.persistence.dto.SampleDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.kingpiggy.app.persistence.entity.QSampleEntity.sampleEntity;


@RequiredArgsConstructor
public class SampleRepositoryImpl implements SampleRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<SampleDto> findAllData() {
        return queryFactory
                .select(Projections.fields(SampleDto.class,
                        sampleEntity.id.as("id"),
                        sampleEntity.title.as("title"),
                        sampleEntity.description.as("description")
                ))
                .from(
                        sampleEntity
                )
                .fetch();
    }

}
