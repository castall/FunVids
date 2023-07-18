package com.douyin.common.validators;

/**
 * @author castall
 * @date 2023/7/18 20:29
 */
import java.time.LocalDateTime;
import java.util.regex.Pattern;
public class DateTimeValidator {
    private static final String DATETIME_PATTERN = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$";

    public static boolean isValidDateTime(LocalDateTime dateTime) {
        String dateTimeStr = dateTime.toString();
        return Pattern.matches(DATETIME_PATTERN, dateTimeStr);
    }
}