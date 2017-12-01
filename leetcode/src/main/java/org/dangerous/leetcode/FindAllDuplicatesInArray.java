package org.dangerous.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 * 1、hash
 * 2、排序
 * 3、搜索
 * 都不满足O(n)和额外的空间
 * Created by limeng on 17-12-1.
 */
public class FindAllDuplicatesInArray {
    /**
     * Time Limit Exceeded
     * O(n*n)
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //从索引位置开始，先后搜索是否有相同的元素
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    result.add(nums[i]);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 47ms
     * 排序
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates2(int[] nums) {
        //排序
        Arrays.sort(nums);
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            //判断当前元素和后一个元素是否相等
            if (nums[i] == nums[i + 1]) {
                result.add(nums[i]);
                i++;
            }
        }
        return result;
    }

    /**
     * n=nums.length
     * 元素范围 1<=nums[i]<=n
     * 把原来的nums作为map
     * key为Math.abs(nums[i]) - 1，绝对值因为可能出现负值，-1是因为元素范围从1开始
     * value为 "+" "-" 作为出现的次数 "+"出现0次  "-"出现过1次
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates3(int[] nums) {
        List<Integer> newList = new ArrayList<Integer>();     // creating a new List
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;             // Taking the absolute value to find index
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            } else {
                // If it is not greater than 0 (i.e) negative then the number is a duplicate
                newList.add(Math.abs(nums[i]));
            }
        }
        return newList;
    }
}
