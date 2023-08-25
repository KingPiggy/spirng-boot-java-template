package com.kingpiggy.app.batch.statistic.dailyuserate;


import com.kingpiggy.app.common.JobUtil;
import com.kingpiggy.app.core.common.utils.ErrorUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.kingpiggy.app.batch.statistic.dailyuserate.DailyUseRateStatBatchConstant.PARAM_DAILY_USE_RATE_STAT;

@Slf4j
@Component
@RequiredArgsConstructor
public class DailyUseRateStatBatchJobScheduler {

    private final DailyUseRateStatBatchConfig dailyUseRateStatBatchConfig;
    private final JobLauncher jobLauncher;

    @Scheduled(cron="0/10 * * * * *") // 10 seconds interval
    public void schedulerForGameA() {
        JobParameters jobParameters = JobUtil.getJobParameters(makeParamMap("Game A"));
        System.out.println(jobParameters);

        try {
            jobLauncher.run(
                    dailyUseRateStatBatchConfig.dailyUseRateStatJob(),
                    jobParameters
            );
        } catch (Exception e) {
            log.error(ErrorUtil.exceptionToString(e));
        }
    }

    @Scheduled(cron="0/10 * * * * *") // 10 seconds interval
    public void schedulerForGameB() {
        JobParameters jobParameters = JobUtil.getJobParameters(makeParamMap("Game B"));
        System.out.println(jobParameters);

        try {
            jobLauncher.run(
                    dailyUseRateStatBatchConfig.dailyUseRateStatJob(),
                    jobParameters
            );
        } catch (Exception e) {
            log.error(ErrorUtil.exceptionToString(e));
        }
    }

    public Map<String, String> makeParamMap(String name) {
        Map<String, String> map = new HashMap<>();
        map.put(PARAM_DAILY_USE_RATE_STAT, name);
        return map;
    }

}
