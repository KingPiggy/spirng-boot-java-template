package com.kingpiggy.app.batch.statistic.dailyuserate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.kingpiggy.app.batch.statistic.dailyuserate.DailyUseRateStatBatchConstant.*;

@Slf4j
@Configuration
@RequiredArgsConstructor
@ConditionalOnProperty(name = "batch.daily-use-rate-stat.enabled", havingValue = "true")
public class DailyUseRateStatBatchConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final DailyUseRateStatBatchService dailyUseRateStatJobService;

    @Bean(name = JOB_DAILY_USE_RATE_STAT)
    public Job dailyUseRateStatJob(){
        return jobBuilderFactory.get(JOB_DAILY_USE_RATE_STAT)
                .start(step1())
                .next(step2())
                .next(step3())
                .listener(jobExecutionListener())
                .build();
    }

    @JobScope
    @Bean
    public JobExecutionListener jobExecutionListener() {
        return new JobExecutionListener() {
            @Override
            public void beforeJob(JobExecution jobExecution) {
                log.info("[JobExecutionListener#beforeJob] job id : [{}],  param : [{}]", jobExecution.getJobId(), jobExecution.getJobParameters().getString(PARAM_DAILY_USE_RATE_STAT));
            }

            @Override
            public void afterJob(JobExecution jobExecution) {
                if (jobExecution.getStatus() == BatchStatus.FAILED) {
                    log.error("[JobExecutionListener#afterJob] jobExecution is " + jobExecution.getStatus());
                }

                log.info("[JobExecutionListener#afterJob] jobExecution is " + jobExecution.getStatus());
            }
        };
    }

    @JobScope
    public Step step1() {
        return stepBuilderFactory.get(STEP1_DAILY_USE_RATE_STAT)
                .tasklet(((contribution, chunkContext) -> {
                    log.info("[step1#tasklet] param : [{}]", chunkContext.getStepContext().getJobParameters().get(PARAM_DAILY_USE_RATE_STAT));
                    dailyUseRateStatJobService.doSomethingA();
                    return RepeatStatus.FINISHED;
                }))
                .build();
    }

    @JobScope
    public Step step2() {
        return stepBuilderFactory.get(STEP2_DAILY_USE_RATE_STAT)
                .tasklet(((contribution, chunkContext) -> {
                    log.info("[step2#tasklet] param : [{}]", chunkContext.getStepContext().getJobParameters().get(PARAM_DAILY_USE_RATE_STAT));
                    dailyUseRateStatJobService.doSomethingB();
                    return RepeatStatus.FINISHED;
                }))
                .build();
    }

    @JobScope
    public Step step3() {
        return stepBuilderFactory.get(STEP3_DAILY_USE_RATE_STAT)
                .tasklet(new DailyUseRateStatBatchTasklet())
                .build();
    }

}
