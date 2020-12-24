import jdk.nashorn.internal.ir.ReturnNode;

import java.util.*;


/**
 * Create by Idea2019
 *
 * @Project SpringDataJpaTest
 * @ClassName Test
 * @Author Tim Smith
 * @Date 2019/11/4 14:19
 * @Version 1.0
 * @description: TODO
 */
public class Test {

    /**
     * 题目 nums=[2,7,11,13]
     * target = 9
     * <p>
     * nums[0] + nums[1] = target =9
     * return [0,1]
     *
     * @param args
     */
    //{1=4, 2=0, 3=6, 6=7, 7=1, 8=5}
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 13, 1, 8, 3, 6, 5};
//        Map fun = fun(nums);
//        System.out.println(fun);
        List<int[]> list = fun2(nums);
        for (int i = 0; i < list.size() ; i++) {
            System.out.println(Arrays.toString(list.get(i)));
        }
    }
    public static List<int[]> fun2(int[] nums) {
        ArrayList<int[]> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list1.add(nums[i]);
            if (nums[i] <= 9) {
                int temp = 9 - nums[i];
                if (list1.contains(temp)) {
                    int index = list1.indexOf(temp);
                    int[] getIndex = new int[2];
                    getIndex[0] = i;
                    getIndex[1] = index;
                    list.add(getIndex);
                }
            }
        }
        return list;
    }


    public static Map fun(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 9) {
                hashMap.put(nums[i], i);
            }
        }

        Set<Integer> keySet = hashMap.keySet();
        for (Integer integer : keySet) {
            int temp = 9 - integer;
            if (keySet.contains(temp)) {
                map.put(integer, hashMap.get(integer));
                map.put(temp, hashMap.get(temp));
            }
        }
        return map;
    }
}
