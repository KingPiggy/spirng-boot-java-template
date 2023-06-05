package com.kingpiggy.app.server.web.controller;

import com.kingpiggy.app.core.common.web.ApiResponse;
import com.kingpiggy.app.server.service.HelloService;
import com.kingpiggy.app.server.web.dto.HelloDto;
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
    public ApiResponse<HelloDto> hello() {
        return ApiResponse.OK(helloService.hello());
    }

}
