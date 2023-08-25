package com.kingpiggy.app.batch.statistic.dailyuserate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DailyUseRateStatBatchService {

    public void doSomethingA() {
        log.info("doSomething... A");
    }

    public void doSomethingB() {
        log.info("doSomething... B");
    }

    public void doSomethingC() {
        log.info("doSomething... C");
    }

}
