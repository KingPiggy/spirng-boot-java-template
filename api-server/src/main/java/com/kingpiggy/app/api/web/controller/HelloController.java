package com.kingpiggy.app.api.web.controller;

import com.kingpiggy.app.core.common.web.ApiResponse;
import com.kingpiggy.app.api.service.HelloService;
import com.kingpiggy.app.api.web.dto.response.HelloResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/hello")
    public ApiResponse<HelloResponse> hello() {
        return ApiResponse.OK(helloService.hello());
    }

}
