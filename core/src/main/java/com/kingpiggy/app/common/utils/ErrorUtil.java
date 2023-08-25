package com.kingpiggy.app.common.utils;

import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

@Component
public class ErrorUtil {

    public static String exceptionToString(Throwable exception) {
        int maxLength = 1000;

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);

        String stackTraceString = sw.toString();
        if (stackTraceString.length() > maxLength) {
            stackTraceString = stackTraceString.substring(0, maxLength) + " ...";
        }
        return stackTraceString;
    }

}
