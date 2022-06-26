package com.patika.odev_1.service.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public  class DateHelper {

    public static Date getCurrentDate() throws ParseException {
        SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.parse(formatter.format(date));
    }

}
