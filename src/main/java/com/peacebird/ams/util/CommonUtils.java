package com.peacebird.ams.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @autor kevin.dai
 * @Date 2018/1/26
 */
public class CommonUtils {



    public static String formatDate(Date date,String pattern){
        return new SimpleDateFormat(pattern).format(date);
    }



}
