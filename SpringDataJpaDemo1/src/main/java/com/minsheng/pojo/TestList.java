package com.minsheng.pojo;


import java.util.*;

/**
 * Create by Idea2019
 *
 * @Project SpringDataJpaTest
 * @ClassName TestList
 * @Author Tim Smith
 * @Date 2019/11/1 23:59
 * @Version 1.0
 * @description: TODO
 */
public class TestList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String[] arrStr = new String[]{"1st", "2nd", "3rd", "4th", "5th", "1st", "3rd", "8th", "9th", "3rd", "5th"};
        List<String> asList = Arrays.asList(arrStr);
        System.out.println("统计1st出现的次数");
        int i = Collections.frequency(asList, "1st");
        System.out.println("1st出现的次数:" + i);
        System.out.println("统计所有对象及出现的次数");
        HashSet<String> set = new HashSet<>();
        set.addAll(asList);
        for (String s : set) {
            System.out.println(s + "出现的次数:" + Collections.frequency(asList, s));
        }
        System.out.println("用map统计所有元素出现的次数");
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : asList) {
            Integer integer = map.get(s);
            map.put(s, (integer == null) ? 1 : integer + 1);
        }
        printMap(map);
        System.out.println("用map统计所有元素出现的次数但只输出重复的元素");
        printMap2(map);
        System.out.println("只统计出现重复的元素和出现的次数");
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        for (String s : asList) {
            if (set1.contains(s)) {
                set2.add(s);
            } else {
                set1.add(s);
            }
        }
        for (String s : set2) {
            System.out.println(s + "是重复出现的元素,出现的次数:" + Collections.frequency(asList, s));
        }
        System.out.println("求斐波那契数列数字");
        Fb(4);
    }

    private static void Fb(int count) {
        int i;
        int a = 0;
        int b = 1;
        int temp = 0;
        int he = 1 ;
        if (count>1){
            for (i = 1; i < count; i++) {
                temp = a + b;
                a = b;
                b = temp;
                he += temp;
            }
        }else{
            temp = 1;
        }

        System.out.println("第"+count+"个数字"+temp);
        System.out.println("和为"+he);
    }

    private static void printMap(HashMap<String, Integer> map) {
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            System.out.println("Key-Value:" + entry.getKey() + "-" + entry.getValue());
        }
    }

    private static void printMap2(HashMap<String, Integer> map) {
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            if (entry.getValue() > 1)
                System.out.println("重复的元素==Key-Value:" + entry.getKey() + "-" + entry.getValue());
        }
    }

}
