package com.kingpiggy.app.batch.statistic.weeklyuserate.processing;

import com.kingpiggy.app.batch.statistic.weeklyuserate.dto.WeeklyUseRateDto;
import org.springframework.batch.item.ItemReader;

import java.util.Iterator;
import java.util.List;

public class WeeklyUseRateStatBatchItemReader implements ItemReader<WeeklyUseRateDto> {

    private final Iterator<WeeklyUseRateDto> iterator;

    public WeeklyUseRateStatBatchItemReader(List<WeeklyUseRateDto> dtos) {
        this.iterator = dtos.iterator();
    }

    @Override
    public WeeklyUseRateDto read() throws Exception {
        return iterator.hasNext() ? iterator.next() : null;
    }

}
