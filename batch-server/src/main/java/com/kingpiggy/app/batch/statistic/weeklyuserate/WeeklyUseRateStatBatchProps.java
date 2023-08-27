package com.kingpiggy.app.batch.statistic.weeklyuserate;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class WeeklyUseRateStatBatchProps {

    @Value("${batch.weekly-use-rate-stat.enabled}")
    private boolean enabled;

    @Value("${batch.weekly-use-rate-stat.chunk-size}")
    private Integer chunkSize;

}
