package com.kingpiggy.app.api.components;

import com.kingpiggy.app.api.web.dto.request.SampleRequest;
import com.kingpiggy.app.api.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class SampleDataInitRunner implements CommandLineRunner {

    private final TestService testService;

    @Override
    public void run(String... args) throws Exception {
        List<SampleRequest> requests = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            SampleRequest request = SampleRequest.builder()
                    .title("Hello World-" + (i+1))
                    .description("Good luck!-" + (i+1))
                    .build();

            requests.add(request);
        }

        testService.saveAll(requests);
    }

}
