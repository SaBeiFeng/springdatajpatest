package com.minsheng.pojo;

public class Test2 {
    public static void main(String[] args) {
        hsnoi(3);
    }

    private static void hsnoi(int i) {
        if (i>0){
            func(i,"left","mid","right");
        }
    }

    private static void func(int i, String from, String mid, String to) {
        if (i==1){
            System.out.println("move from "+from+" to "+to);
        }else{
            func(i-1,from,to,mid);
            func(1,from,mid,to);
            func(i-1,mid,from,to);
        }
    }
}
