package com.kingpiggy.app.batch.statistic.weeklyuserate;


import com.kingpiggy.app.common.JobUtil;
import com.kingpiggy.app.core.common.utils.ErrorUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.kingpiggy.app.batch.statistic.weeklyuserate.WeeklyUseRateStatBatchConstant.PARAM_WEEKLY_USE_RATE_STAT;

@Slf4j
@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name = "batch.weekly-use-rate-stat.enabled", havingValue = "true")
public class WeeklyUseRateStatBatchJobScheduler {

    private final WeeklyUseRateStatBatchConfig weeklyUseRateStatBatchConfig;
    private final JobLauncher jobLauncher;

    @Scheduled(cron="0 * * * * *") // 10 seconds interval
    public void schedulerForWeeklyUseRateStatistic() {
        try {
            jobLauncher.run(
                    weeklyUseRateStatBatchConfig.weeklyUseRateStatJob(),
                    JobUtil.getJobParameters(makeParamMap("South Korea"))
            );
        } catch (Exception e) {
            log.error(ErrorUtil.exceptionToString(e));
        }
    }

    public Map<String, String> makeParamMap(String name) {
        Map<String, String> map = new HashMap<>();
        map.put(PARAM_WEEKLY_USE_RATE_STAT, name);
        return map;
    }

}
