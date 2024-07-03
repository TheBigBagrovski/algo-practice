package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums, return the length of the longest strictly increasing
 * subsequence
 * -----------------------
 * Consider an example - [1,7,8,4,5,6,-1,9]:
 * Let's pick first element - 1 and form the subseqeunce sub1=[1].
 * <p>
 * 7 is greater than previous element so extend the sequence by picking it.   sub1=[1,7].
 * <p>
 * Similarly, we pick 8 as well since it's greater than 7.   sub1=[1,7,8]
 * <p>
 * Now we cant extend it further. We can't simply discard previous sequence and start with 4 nor can we discard 7,8
 * and place 4 instead of them because we don't know if future increasing subsequence will be of more length or not.
 * So we keep both previous subsequence as well as try picking 4 by forming a new subsequence. It's better to form new
 * subsequence and place 4 after 1 to maximize new sequence length. So we have sub1=[1,7,8] and sub2=[1,4]
 * <p>
 * Can we add 5 in any of the sequence? Yes we can add it to sub2. If it wasn't possible we would have tried the same
 * approach as in 4th step and created another subsequence list.   sub1=[1,7,8], sub2=[1,4,5]
 * <p>
 * Similarly, add 6 to only possible list - cur2.   sub1=[1,7,8], sub2=[1,4,5,6]
 * Now, -1 cant extend any of the existing subsequence. So we need to form another sequence. Notice we cant copy and
 * use any elements from existing subsequences before -1 either, since -1 is lowest. sub1=[1,7,8], sub2=[1,4,5,6], sub3=[-1]
 * <p>
 * Now, 9 can be used to extend all of the list. At last, we get   sub1=[1,7,8,9], sub2=[1,4,5,6,9], sub3=[-1,9]
 * <p>
 * We finally pick the maximum length of all lists formed till now. This approach works and gets us the correct LIS
 * but it seems like just another inefficient approach because it's costly to maintain multiple lists and search
 * through all of them when including a new element or making a new list. Is there a way to speed up this process? Yes.
 * We can just maintain a single list and mark multiple lists inside it. Again, an example will better explain this.
 * <p>
 * Consider the same example as above - [1,7,8,4,5,6,-1,9]:
 * <p>
 * Pick first element - 1 and form the subseqeunce sub=[1].
 * <p>
 * 7 is greater than 1 so extend the existing subsequence by picking it.   sub=[1,7].
 * <p>
 * Similarly, we pick 8 as well since it's greater than 7.   sub=[1,7,8]
 * <p>
 * Now comes the main part. We can't extend any existing sequence with 4. So we need to create a new subsequence
 * following 4th step previous approach but this time we will create it inside sub itself by replacing smallest
 * element larger than 4 (Similar to 4th step above where we formed a new sequence after picking smaller elements
 * than 4 from existing sequence).
 * <p>
 * [1,    4,      8]
 * ^sub2   ^sub1
 * <p>
 * This replacement technique works because replaced elements dont matter to us
 * We only used end elements of existing lists to check if they can be extended otherwise form newer lists
 * And since we have replaced a bigger element with smaller one it wont affect the
 * step of creating new list after taking some part of existing list (see step 4 in above approach)
 * Now, we can't extend with 5 either. We follow the same approach as step 4.
 * <p>
 * [1,    4,    5]
 * ^sub2
 * <p>
 * Think of it as extending sub2 in 5th step of above appraoch
 * Also, we can see sub2 replaced sub1 meaning any subsequence formed with sub2 always
 * has better chance of being LIS than sub1.
 * We get 6 now and we can extend the sub list by picking it.
 * <p>
 * [1,    4,    5,    6]
 * ^sub2
 * Cant extend with -1. So, Replace -
 * <p>
 * [-1,    4,    5,   6]
 * ^sub3		       ^sub2
 * <p>
 * We have again formed a new list internally by replacing smallest element larger than -1 from exisiting list
 * We get 9 which is greater than the end of our list and thus can be used to extend the list
 * <p>
 * [-1,    4,    5,    6,    9]
 * ^sub3		              ^sub2
 * <p>
 * Finally the length of our maintained list will denote the LIS length = `5`. Do note that it wont give the LIS itself
 * but just correct length of it.
 * <p>
 * The optimization which improves this approach over DP is applying Binary search when we can't extend the sequence
 * and need to replace some element from maintained list - sub. The list always remains sorted and thus binary search
 * gives us the correct index of element in list which will be replaced by current element under iteration.
 * Time Complexity : O(NlogN)
 * Space Complexity : O(N)
 * -----------------------
 * можно не создавать допсписок, а работать в исходном массиве, тогда будет конст память
 */
public class LC300 {

    public static void main(String[] args) {
        int[] array = new int[]{3, 5, 1, 4, 7, 2, 4, 9, 3, 0};
        System.out.println(lengthOfLIS(array));
        array = new int[]{3};
        System.out.println(lengthOfLIS(array));
        array = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(array));
        array = new int[]{0,1,0,3,2,3};
        System.out.println(lengthOfLIS(array));
        array = new int[]{18,55,66,2,3,54};
        System.out.println(lengthOfLIS(array));
        array = new int[]{3,5,6,2,5,4,19,5,6,7,12};
        System.out.println(lengthOfLIS(array));
    }
    // 3 5 6
    //

    public static int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int num : nums) {
            if (num > list.get(list.size() - 1)) {
                list.add(num);
            } else if (num < list.get(list.size() - 1)) {
                int lb = findLowerBound(list, num);
                list.set(lb, num);
            }
        }
        return list.size();
    }

    private static int findLowerBound(List<Integer> list, int num) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < num) {
                left = mid + 1;
                if (list.get(left) > num) {
                    return left;
                }
            } else {
                right = mid;
            }
        }
        return left;
    }

}
