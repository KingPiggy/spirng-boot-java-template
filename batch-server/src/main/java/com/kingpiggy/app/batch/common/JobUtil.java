package com.kingpiggy.app.batch.common;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Component
public class JobUtil {

    public static JobParameters getJobParameters(Map<String, String> parameterMap) {
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();

        // default param
        parameterMap.put("jobExecuteDate", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        for (Map.Entry<String, String> entry : parameterMap.entrySet()) {
            jobParametersBuilder.addString(entry.getKey(), entry.getValue());
        }

        return jobParametersBuilder.toJobParameters();
    }

}
