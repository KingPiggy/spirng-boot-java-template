package com.kingpiggy.app.server.service;

import com.kingpiggy.app.server.web.dto.HelloDto;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public HelloDto hello() {
        return new HelloDto("Hello World!");
    }

}
