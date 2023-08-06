package com.kingpiggy.app.service;

import com.kingpiggy.app.persistence.dto.SampleDto;
import com.kingpiggy.app.persistence.entity.SampleEntity;
import com.kingpiggy.app.persistence.mapper.SampleMapper;
import com.kingpiggy.app.persistence.repository.SampleRepository;
import com.kingpiggy.app.web.dto.request.SampleRequest;
import com.kingpiggy.app.web.dto.response.SampleResponse;
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
