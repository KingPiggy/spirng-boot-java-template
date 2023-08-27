package com.kingpiggy.app.batch.statistic.weeklyuserate.processing;

import com.kingpiggy.app.batch.statistic.weeklyuserate.dto.WeeklyUseRateDto;
import org.springframework.batch.item.ItemProcessor;

public class WeeklyUseRateStatBatchItemProcessor implements ItemProcessor<WeeklyUseRateDto, WeeklyUseRateDto> {

    @Override
    public WeeklyUseRateDto process(WeeklyUseRateDto item) throws Exception {
        item.setProcessedYn("Y");
        return item;
    }

}
