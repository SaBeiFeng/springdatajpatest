package com.minsheng.Tests;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by Idea2019
 *
 * @Project SpringDataJpaTest
 * @ClassName TestStringBuilder
 * @Author Tim Smith
 * @Date 2019/10/11 1:10
 * @Version 1.0
 * @description: TODO
 */
public class TestStringBuilder {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
		List list = new ArrayList();
        String string = "1";
//        StringBuilder sBuilder = new StringBuilder(string);
        for (int i = 0; i < 100000; i++) {
            Integer a = Integer.parseInt(string) + i;
//            sBuilder.append(",").append(a);
			String str = a.toString();
			list.add(str);
        }
//		for (Object object : list) {
//			String str = object.toString();
//			System.out.println(str);
//		}
//        String str = "[" + sBuilder.toString() + "]";
        System.out.println(list);
        long end = System.currentTimeMillis();
        System.out.println("共耗时" + (end - start));
        // 不可变对象耗时604
    }
}
