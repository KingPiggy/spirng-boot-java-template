package com.kingpiggy.app.batch.statistic.weeklyuserate;

import com.kingpiggy.app.batch.statistic.weeklyuserate.dto.WeeklyUseRateDto;
import com.kingpiggy.app.batch.statistic.weeklyuserate.processing.WeeklyUseRateStatBatchItemProcessor;
import com.kingpiggy.app.batch.statistic.weeklyuserate.processing.WeeklyUseRateStatBatchItemReader;
import com.kingpiggy.app.batch.statistic.weeklyuserate.processing.WeeklyUseRateStatBatchItemWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import static com.kingpiggy.app.batch.statistic.weeklyuserate.WeeklyUseRateStatBatchConstant.*;

@Slf4j
@Configuration
@RequiredArgsConstructor
@ConditionalOnProperty(name = "batch.weekly-use-rate-stat.enabled", havingValue = "true")
public class WeeklyUseRateStatBatchConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final WeeklyUseRateStatBatchProps weeklyUseRateStatBatchProps;

    @Bean(name = JOB_WEEKLY_USE_RATE_STAT)
    public Job weeklyUseRateStatJob(){
        return jobBuilderFactory.get(JOB_WEEKLY_USE_RATE_STAT)
                .start(step1())
                .listener(jobExecutionListener())
                .build();
    }

    @JobScope
    @Bean
    public JobExecutionListener jobExecutionListener() {
        return new JobExecutionListener() {
            @Override
            public void beforeJob(JobExecution jobExecution) {
                log.info("[JobExecutionListener#beforeJob] job id : [{}],  param : [{}]", jobExecution.getJobId(), jobExecution.getJobParameters().getString(PARAM_WEEKLY_USE_RATE_STAT));
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
        return stepBuilderFactory.get(STEP1_WEEKLY_USE_RATE_STAT)
                .<WeeklyUseRateDto, WeeklyUseRateDto> chunk(weeklyUseRateStatBatchProps.getChunkSize())
                .reader(reader(null))
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    @StepScope
    public WeeklyUseRateStatBatchItemReader reader(@Value("#{jobParameters[" + PARAM_WEEKLY_USE_RATE_STAT + "]}") String region) {
        log.info("region : [{}]", region);
        return new WeeklyUseRateStatBatchItemReader(getWeeklyUseRateData());
    }

    @Bean
    @StepScope
    public WeeklyUseRateStatBatchItemProcessor processor() {
        return new WeeklyUseRateStatBatchItemProcessor();
    }

    @Bean
    @StepScope
    public WeeklyUseRateStatBatchItemWriter writer() {
        return new WeeklyUseRateStatBatchItemWriter();
    }

    private List<WeeklyUseRateDto> getWeeklyUseRateData() {
        List<WeeklyUseRateDto> sampleDataList = new ArrayList<>();

        for (int i=0; i<100; i++) {
            sampleDataList.add(new WeeklyUseRateDto("Name_" + i, "N"));
        }

        return sampleDataList;
    }

}
