package com.example.currencyapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppUtils {

    final static String STANDARD_DATE_FORMAT = "dd-MM-yyyy";
    final static String INVERSE_DATE_FORMAT = "yyyy-MM-dd";

    public static String formatToStandardDate(Date date) {
        return new SimpleDateFormat(STANDARD_DATE_FORMAT).format(date);
    }

    public static String formatToInverseDate(Date date) {
        return new SimpleDateFormat(INVERSE_DATE_FORMAT).format(date);
    }
}
