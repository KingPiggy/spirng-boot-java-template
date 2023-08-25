package com.kingpiggy.app.api.service;

import com.kingpiggy.app.api.web.dto.request.SampleRequest;
import com.kingpiggy.app.api.web.dto.response.SampleResponse;
import com.kingpiggy.app.core.persistence.dto.SampleDto;
import com.kingpiggy.app.core.persistence.entity.SampleEntity;
import com.kingpiggy.app.core.persistence.mapper.SampleMapper;
import com.kingpiggy.app.core.persistence.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService {

    private final SampleRepository sampleRepository;
    private final SampleMapper sampleMapper;

    @Transactional(readOnly = true)
    public List<SampleResponse> findAllByDataJpa() {
        return sampleRepository.findAll().stream()
                .map(this::makeSampleResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SampleDto> findAllByQueryDsl() {
        return sampleRepository.findAllData();
    }

    @Transactional(readOnly = true)
    public int countAllByMybatis() {
        return sampleMapper.countAll();
    }

    @Transactional
    public void saveAll(List<SampleRequest> requests) {
        sampleRepository.saveAll(requests
                .stream()
                .map(SampleRequest::toEntity)
                .collect(Collectors.toList())
        );
    }

    private SampleResponse makeSampleResponse(SampleEntity sampleEntity) {
        return SampleResponse.builder()
                .title(sampleEntity.getTitle())
                .description(sampleEntity.getDescription())
                .build();
    }

}
