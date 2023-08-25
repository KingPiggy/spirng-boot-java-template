package com.kingpiggy.app.api.service;

import com.kingpiggy.app.api.web.dto.response.HelloResponse;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public HelloResponse hello() {
        return new HelloResponse("Hello World!");
    }

}
