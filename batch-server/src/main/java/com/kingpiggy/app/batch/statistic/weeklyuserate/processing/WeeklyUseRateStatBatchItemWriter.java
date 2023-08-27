package com.kingpiggy.app.batch.statistic.weeklyuserate.processing;

import com.kingpiggy.app.batch.statistic.weeklyuserate.dto.WeeklyUseRateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

@Slf4j
public class WeeklyUseRateStatBatchItemWriter implements ItemWriter<WeeklyUseRateDto> {

    @Override
    public void write(List<? extends WeeklyUseRateDto> dtos) throws Exception {
        log.info("[WeeklyUseRateStatBatchItemWriter#write] write start. size : [{}]", dtos.size());

        for (WeeklyUseRateDto dto : dtos) {
            log.info("dto : [{}]", dto.toString());
        }
    }

}
