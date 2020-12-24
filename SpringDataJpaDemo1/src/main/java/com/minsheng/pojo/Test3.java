package com.minsheng.pojo;

public class Test3 {
    //尝试使用递归的方式进行斐波那契数列的求值,但是不能创造太多的栈帧,应该只调用本身--暂时运行不对
    //1,1,2,3,5,8,13   no相当于索引值,result存放结果
    public static void main(String[] args) {
        long fb = fb(3, 1);
        System.out.println(fb);
    }

    private static long fb(int no,long result) {
        if (no<=0){
            return 0;
        }else if (no==1){
            return result;
        }else {
            int a = 0;
            int b = 1;
            int temp = 0;

            return fb(no-1,result);
        }
    }
}
