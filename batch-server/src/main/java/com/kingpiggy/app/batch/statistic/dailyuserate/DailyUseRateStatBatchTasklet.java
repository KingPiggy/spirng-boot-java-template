package com.kingpiggy.app.batch.statistic.dailyuserate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import static com.kingpiggy.app.batch.statistic.dailyuserate.DailyUseRateStatBatchConstant.PARAM_DAILY_USE_RATE_STAT;

@Slf4j
public class DailyUseRateStatBatchTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("[step3#tasklet] param : [{}]", chunkContext.getStepContext().getJobParameters().get(PARAM_DAILY_USE_RATE_STAT));
        return RepeatStatus.FINISHED;
    }

}
