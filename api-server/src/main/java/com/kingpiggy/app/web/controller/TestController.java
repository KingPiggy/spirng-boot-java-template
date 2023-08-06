package com.kingpiggy.app.web.controller;

import com.kingpiggy.app.common.web.ApiResponse;
import com.kingpiggy.app.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/data-jpa")
    public ApiResponse getDataByDataJpa() {
        return ApiResponse.OK(testService.findAllByDataJpa());
    }

    @GetMapping("/querydsl")
    public ApiResponse getDataByQueryDsl() {
        return ApiResponse.OK(testService.findAllByQueryDsl());
    }

    @GetMapping("/mybatis")
    public ApiResponse getDataByMybatis() {
        return ApiResponse.OK(testService.countAllByMybatis());
    }

}
