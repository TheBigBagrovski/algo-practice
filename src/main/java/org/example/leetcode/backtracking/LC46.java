package org.example.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC46 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
//        List<Integer> list = Arrays.asList(arr);
        System.out.println(permute(arr));
    }

    public static List<List<Integer>> permute(int[] nums) { // O(n!), O(n!)
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
