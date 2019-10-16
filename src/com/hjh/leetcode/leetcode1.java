package com.hjh.leetcode;

/**
 * @author hejiahao
 * @version 1.0
 * @date 2019/7/1 16:50
 * @projct_name leetcode
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 问题：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 分析：取数组的第一个值与数组其余值相加看是否为目标值，如不是用第二个与剩余值相加。类似排序
 */
public class leetcode1 {
    public int[] twoSum(int[] nums,int target){
        int[] result = new int[2];
        for (int i = 0;i<nums.length;i++){
            for(int j = i+1; j< nums.length ;j++){
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }

        }
        return result;
    }

    /**
     * 大神的解题思路，通过map判断里面是否存在合适的值
     * 通过数组 逻辑与&方式判断是否相等
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        return min(nums, target);
    }

    public int[] o2(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public int[] on(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            int targetResult = target - nums[i];
            if(map.get(nums[i]) != null && nums[i] * 2 == target) {
                return new int[] {map.get(targetResult), i};
            }

            if(map.get(targetResult) != null) {
                return new int[] {map.get(targetResult), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] min(int[] nums, int target) {
        int indexArrayMax = 2047;
        int[] indexArrays = new int[indexArrayMax + 1];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            int index = diff & indexArrayMax;
            if (indexArrays[index] != 0) {
                return new int[] { indexArrays[index] - 1, i };
            }
            indexArrays[nums[i] & indexArrayMax] = i + 1;
        }
        throw new IllegalArgumentException("No two sum value");
    }

}
