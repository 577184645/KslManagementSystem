package com.ruoyi.system.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class numberUtil {
    public  static String numberToStringAddOne(Integer num){
        num++;
        if(num<10){
            return "000"+num;
        }else if(num<100){
            return "00"+num;
        }else if(num<1000){
            return "0"+num;
        }

        return num.toString();

    }



    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
}
