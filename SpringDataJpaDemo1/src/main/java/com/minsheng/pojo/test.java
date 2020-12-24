package com.minsheng.pojo;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.logging.Logger;

public class test {
    private static final Logger logger = Logger.getLogger("test");


    public static Date beforeDate(Date date,int days){




        Calendar c = Calendar.getInstance();
        c.setTime(date);
        System.out.println(c.toString());
        //入库 更新时间
        c.add(Calendar.DAY_OF_YEAR,-days);
        //入库 days天前时间
        System.out.println(c.toString());
        return c.getTime();
        //给用户 当前时间


    }
    public static String getBack(){
        String s = "这个桌子不好!";
        return s;

    }
//"yyyy/MM/dd HH:mm:ss 不格式化的格式 挺好看的 还好辨认"
    public static void main(String[] args) {
        Date date = beforeDate(new Date(), 2);
        SimpleDateFormat format = new SimpleDateFormat();
        String s = format.format(date);
        System.out.println(s);
        System.out.println(getBack());
    }
}