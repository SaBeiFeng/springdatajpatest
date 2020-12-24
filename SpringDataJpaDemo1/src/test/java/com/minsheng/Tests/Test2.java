package com.minsheng.Tests;

import java.util.*;

/**
 * Create by Idea2019
 *
 * @Project SpringDataJpaTest
 * @ClassName Test2
 * @Author Tim Smith
 * @Date 2019/11/5 11:24
 * @Version 1.0
 * @description: TODO
 */
public class Test2 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 5};
        List<Integer> list = Arrays.asList(arr);
        for (int i = 0; i < arr.length; i++) {
            if(Collections.frequency(list,arr[i])==2){
                System.out.println("重复的元素:"+arr[i]);
            }
        }
        Timer timer=new Timer();//实例化Timer类
        timer.schedule(new TimerTask(){
            public void run(){
                System.out.println("退出");
                this.cancel();}},500);//五百毫秒
    }
}
