package org.dangerous.leetcode;

import java.util.Arrays;

/**
 * Created by limeng on 17-6-3.
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        boolean isOdd = result.length%2==0;
        int middle = result.length/2;
        int index = 0;
        int size1 = nums1.length;
        int size2 = nums2.length;
        int i = 0, j = 0;
        while (i < size1 && j < size2) {
            if((index-1) == middle && isOdd){
                return (result[middle] +result[middle-1])/2.0;
            }else if((index-1) == middle){
                return result[middle];
            }
            if (nums1[i] <= nums2[j]) {
                result[index++]=nums1[i];
                i++;
            }else{
                result[index++]=nums2[j];
                j++;
            }

        }
        if(i<size1){
            for (;i<size1;i++){
                if((index-1) == middle && isOdd){
                    return (result[middle] +result[middle-1])/2.0;
                }else if((index-1) == middle){
                    return result[middle];
                }
                result[index++]=nums1[i];
            }
        }
        if(j<size2){
            for (;j<size2;j++){
                if((index-1) == middle && isOdd){
                    return (result[middle] +result[middle-1])/2.0;
                }else if((index-1) == middle){
                    return result[middle];
                }
                result[index++]=nums2[j];
            }
        }
        if(isOdd){
            return (result[middle] +result[middle-1])/2.0;
        }else{
            return result[middle];
        }
    }

    public static void main(String[] args) {
        MedianofTwoSortedArrays medianofTwoSortedArrays = new MedianofTwoSortedArrays();
        System.out.println(medianofTwoSortedArrays.findMedianSortedArrays(new int[]{1,2,3,4,7,8,9,10},new int[]{5,6}));
    }
}
