package com.kingpiggy.app.api.web.controller;

import com.kingpiggy.app.core.common.web.ApiResponse;
import com.kingpiggy.app.api.service.HelloService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/data-jpa")
    public ApiResponse getDataByDataJpa() {
        return ApiResponse.OK(helloService.findAllByDataJpa());
    }

    @GetMapping("/querydsl")
    public ApiResponse getDataByQueryDsl() {
        return ApiResponse.OK(helloService.findAllByQueryDsl());
    }

    @GetMapping("/mybatis")
    public ApiResponse getDataByMybatis() {
        return ApiResponse.OK(helloService.countAllByMybatis());
    }

}
