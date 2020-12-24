package com.minsheng.Tests;

/**
 * Create by Idea2019
 *
 * @Project SpringDataJpaTest
 * @ClassName TestSubstring
 * @Author Tim Smith
 * @Date 2019/10/16 22:37
 * @Version 1.0
 * @description: TODO
 */
public class TestSubstring {
    public static void main(String[] args) {
//        String str = "123456789";
//        String substring = str.substring(4,6);
//        System.out.println(substring);
//        str = substring.substring(1)+substring.substring(0,1);
//        System.out.println(str);
        String string = "emu0633|emu0572|emu0574|emuMM02|emuMM03|emuMM04|emuMM26|emuMM22|emu0650|emu0223";
        String[] split = string.split("\\|");
        for (String s : split) {
            System.out.print(s);
        }
    }


}
