package com.minsheng.Tests;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Create by Idea2019
 *
 * @Project SpringDataJpaTest
 * @ClassName TestSwitch
 * @Author Tim Smith
 * @Date 2019/9/19 22:46
 * @Version 1.0
 * @description: TODO
 */
public class TestSwitch {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
        long start = System.currentTimeMillis();
        String s1 = "99";
        time();
//        String anIf = sentenceIf(s1);
        String aSwitch = sentenceSwitch(s1);
//        System.out.println(anIf);
        System.out.println(aSwitch);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static String sentenceIf(String str) {
        if ("11".equals(str)) {
            str = "0";
        } else if ("03".equals(str)) {
            str = "1";
        } else if ("01".equals(str)) {
            str = "2";
        } else if ("06".equals(str)) {
            str = "3";
        } else if ("50".equals(str)) {
            str = "4";
        } else if ("02".equals(str)) {
            str = "6";
        } else if ("99".equals(str)) {
            str = "9";
        } else {
            return "未找到合适帐户类型";
        }
        return str;
    }

    public static String sentenceSwitch(String str) {
        switch (str) {
            case "11":
                str = "0";
                break;
            case "03":
                str = "1";
                break;
            case "01":
                str = "2";
                break;
            case "06":
                str = "3";
                break;
            case "50":
                str = "4";
                break;
            case "02":
                str = "6";
                break;
            case "99":
                str = "9";
                break;
            default:
                str = "未找到合适的帐户类型";
                break;
        }
        return str;
    }

    public static void time(){
        ArrayList<Object> list = new ArrayList<>();
        String s = "hello";
        for (int i = 0; i < 10000; i++) {
            s += "哈哈儿";
        }
        System.out.println(s);
    }
}
