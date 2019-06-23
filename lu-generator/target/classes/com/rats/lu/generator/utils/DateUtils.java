package com.rats.lu.generator.utils;

import java.text.DateFormat;
import java.util.Date;

/**
 * Copyright (C) 2016 
 * <p/>
 *
 * @author : hanbing
 * @version : v1.0
 * @since : 2016/12/12
 */
public class DateUtils {
    public static String now() {
        return DateFormat.getDateTimeInstance().format(new Date());
    }
}
