package com.minsheng.Tests;

import sun.util.resources.cldr.te.CurrencyNames_te;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by Idea2019
 *
 * @Project SpringDataJpaTest
 * @ClassName TestMap
 * @Author Tim Smith
 * @Date 2019/9/17 21:34
 * @Version 1.0
 * @description: 组装一个map集合, 包含两个k-v参数和两个list集合,list集合中分别封装了一个map,
 * 调用domain方法,将context里面的集合取出来,转换为M1和M2,然后重新封装进去,也可以使用json进行打印,
 * 所有的key都换更换
 * 仅限于list里面只有一个map
 */
public class TestMap {
    public static void main(String[] args) {
        Map<String, Object> context = new HashMap<>();
        List<Map<String, String>> list1 = new ArrayList<>();
        List<Map<String, String>> list2 = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        map1.put("1st", "三国演义");
        map1.put("2nd", "红楼梦");
        map1.put("3rd", "西游记");
        map1.put("4th", "水浒传");
        map2.put("1st", "罗贯中");
        map2.put("2nd", "曹雪芹");
        map2.put("3rd", "大仲马");
        map2.put("5th", "小仲马");
        list1.add(map1);
        list2.add(map2);
        context.put("first", "blood");
        context.put("second", "nothing");
        context.put("list1", list1);
        context.put("list2", list2);
        System.out.println(context.toString());
        Map<String, Object> result = domain(context);
        String string = result.toString();
        String C1 = (String)result.get("字段一");
        String C2 = (String)result.get("字段二");
        String m1 = result.get("M1").toString();
        String m2 = result.get("M2").toString();
        System.out.println(string);
        System.out.println(C1);
        System.out.println(C2);
        System.out.println(m1);
        System.out.println(m2);
    }

    private static Map<String, Object> domain(Map<String, Object> context) {
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("字段一", context.get("first"));
        hashMap.put("字段二", context.get("second"));
        List list1 = (List) context.get("list1");
        List list2 = (List) context.get("list2");
        Map<String, String> map1 = changeMap(list1, "M1");
        Map<String, String> map2 = changeMap(list2, "M2");
        hashMap.put("M1",map1);
        hashMap.put("M2",map2);
        return hashMap;
    }

    private static Map<String,String> changeMap(List list,String keyName) {
        HashMap<String, String> map = new HashMap<>();
        for (Object o : list) {
            Map<String, String> EMap = (Map<String, String>) o;
            if (EMap.containsKey("1st")){
                map.put("1",EMap.get("1st"));
            }
            if (EMap.containsKey("2nd")){
                map.put("2",EMap.get("2nd"));
            }
            if (EMap.containsKey("3rd")){
                map.put("3",EMap.get("3rd"));
            }
            if (EMap.containsKey("4th")){
                map.put("4",EMap.get("4th"));
            }
            if (EMap.containsKey("5th")){
                map.put("5",EMap.get("5th"));
            }
        }
        return map;
    }
}
