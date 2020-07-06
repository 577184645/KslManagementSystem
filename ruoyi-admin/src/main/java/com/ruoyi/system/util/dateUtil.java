package com.ruoyi.system.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public  class dateUtil {

    public static String dataToString(String formatdate, Date date){
        SimpleDateFormat format = new SimpleDateFormat(formatdate);
        return  format.format(date);
    }

}
