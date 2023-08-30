package com.kingpiggy.app.api.service;

import com.kingpiggy.app.api.web.dto.request.SampleRequest;
import com.kingpiggy.app.api.web.dto.response.HelloResponse;
import com.kingpiggy.app.core.persistence.dto.HelloDto;
import com.kingpiggy.app.core.persistence.entity.HelloEntity;
import com.kingpiggy.app.core.persistence.mapper.HelloMapper;
import com.kingpiggy.app.core.persistence.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class HelloService {

    private final HelloRepository helloRepository;
    private final HelloMapper helloMapper;

    @Transactional(readOnly = true)
    public List<HelloResponse> findAllByDataJpa() {
        return helloRepository.findAll().stream()
                .map(this::makeSampleResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<HelloDto> findAllByQueryDsl() {
        return helloRepository.findAllData();
    }

    @Transactional(readOnly = true)
    public int countAllByMybatis() {
        return helloMapper.countAll();
    }

    @Transactional
    public void saveAll(List<SampleRequest> requests) {
        helloRepository.saveAll(requests
                .stream()
                .map(SampleRequest::toEntity)
                .collect(Collectors.toList())
        );
    }

    private HelloResponse makeSampleResponse(HelloEntity helloEntity) {
        return HelloResponse.builder()
                .title(helloEntity.getTitle())
                .description(helloEntity.getDescription())
                .build();
    }

}
