package com.kingpiggy.app.service;

import com.kingpiggy.app.web.dto.response.HelloResponse;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public HelloResponse hello() {
        return new HelloResponse("Hello World!");
    }

}
