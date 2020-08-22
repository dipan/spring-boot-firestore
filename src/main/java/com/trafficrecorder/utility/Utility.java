package com.trafficrecorder.utility;

import com.trafficrecorder.api.RestExecutor;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Utility {
    public static SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat("dd MMM yyyy, HH:mm:ss");
    public static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");

    public static final Pattern BOOLEAN_TRUE_PATTERN = Pattern.compile("^(y(es)?)|(t(rue)?)$", Pattern.CASE_INSENSITIVE);

    public static Boolean isTrue(Object value, Boolean defaultValue) {
        return value == null ? defaultValue : Boolean.valueOf(BOOLEAN_TRUE_PATTERN.matcher(value.toString()).matches());
    }

    public static boolean isStringEmptyOrNull(String string) {
        return string == null || string.trim().length() == 0 || string.trim().equalsIgnoreCase("null");
    }

    public static boolean isStringNonEmpty(String string) {
        return string != null && string.trim().length() > 0 && !string.trim().equalsIgnoreCase("null");
    }

    public static String getFormattedDate(SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date());
    }

    public static long getUTCTimestamp() {
        return new DateTime(new DateTime(), DateTimeZone.UTC).getMillis();
    }

    public static ResponseEntity<Object> buildRestResponse(RestExecutor restExecutor){
        ResponseEntity<Object> execute = restExecutor.execute();
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}
