package problems.easy;

import problem.Problem;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Matthew E on 5/8/2024 at 10:50 AM for the project LaptopLeetCode
 */
public class RemoveDuplicatesFromSortedArray  extends Problem {
    @Override
    public void start() {
        int[] nums1 = new int[] {1,1,2};

        System.out.print("Init: ");printArr(nums1);

        removeDuplicates(nums1);
        System.out.print("\nRemoved: ");printArr(nums1);



    }

    public int removeDuplicates(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>();

        int lastIndex = 0;
        int endIndex=nums.length-1;


        for (int i = 0; i <endIndex; i++) {
            if (hashSet.add(nums[i])) {
                nums[lastIndex++] = nums[i];
            } else {
                swap(nums, i,endIndex);
                endIndex--;
                i--;

            }

        }


        return hashSet.size();
    }
    public void swap(int[] nums, int curIndex, int endIndex) {


        int temp = nums[curIndex];

        nums[curIndex] = nums[endIndex];
        nums[endIndex] = temp;
    }
}
