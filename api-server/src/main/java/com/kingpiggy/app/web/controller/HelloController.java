package com.kingpiggy.app.web.controller;

import com.kingpiggy.app.common.web.ApiResponse;
import com.kingpiggy.app.service.HelloService;
import com.kingpiggy.app.web.dto.response.HelloResponse;
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
