package problems.hard;

import api.MultiTreeSet;
import problem.Problem;

import java.util.*;

/**
 * Created by Matthew E on 5/9/2024 at 12:48 PM for the project LaptopLeetCode
 */
public class MedianOfTwoSortedArrs  extends Problem{
    @Override
    public void start() {

//        System.out.println(findMedianSortedArrays(new int[]{1,3},new int[]{2}));
//        System.out.println(findMedianSortedArrays(new int[]{},new int[]{1,2,3,4,5}));
        System.out.println(findMedianSortedArrays(new int[]{0,0},new int[]{0,0}));
    }

    public int findMiddleValue(MultiTreeSet<Integer> heap) {
        int middleIndex = heap.size() / 2;
        int middleValue = 0;

        if (heap.size() % 2 == 0) {
            // If even number of elements, we need to find the two middle elements
            int count = 0;
            int prevValue = -1;

            for (Map.Entry<Integer, Integer> entry : heap.map.entrySet()) {
                int value = entry.getKey();
                int freq = entry.getValue();
                count += freq;

                if (count >= middleIndex) {
                    if (count == middleIndex) {
                        middleValue += value;
                    } else {
                        if (middleIndex - count + freq == 0) {
                            middleValue += value + prevValue;
                        } else {
                            middleValue += value * 2;
                        }
                    }
                    break;
                }
                prevValue = value;
            }
        } else {
            // If odd number of elements, simply find the middle element
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : heap.map.entrySet()) {
                int value = entry.getKey();
                int freq = entry.getValue();
                count += freq;
                if (count > middleIndex) {
                    middleValue = value * 2;
                    break;
                }
            }
        }
        return middleValue;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newArr =new int[nums1.length+nums2.length];
        MultiTreeSet<Integer> heap = new MultiTreeSet<>();


        for (int i : nums1)heap.add(i);
        for (int i : nums2)heap.add(i);

        List<Integer> list = heap.getList();
        System.out.println(list);

        if (list.size()% 2==1) {
            int middle = list.size()/2;
            return list.get(middle);
        } else {
            // 1 2 3 4
            double p1  = list.get(list.size() / 2);
            double p2  = list.get((list.size() / 2)-1);
            return (p1+p2)/2.0;
        }


    }
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        MultiTreeSet<Integer> heap = new MultiTreeSet<>();
//
//
//        for (int i : nums1)heap.add(i);
//        for (int i : nums2)heap.add(i);
//
//        System.out.println(heap);
//        if (heap.size()==1)return heap.pollFirst();
//
//        if (heap.size()%2==1) {
//            System.out.println("ODD");
//            int middleVal = 0;
//
//            System.out.println(heap);
//
//            for (int i = 0; i < (heap.size()/2)+2; i++) {
//                middleVal = heap.pollFirst();
//            }
//            System.out.println(middleVal);
//            return middleVal;
//        } else {
//            int v1 = 0;
//            System.out.println(heap);
//            int v2 = 0;
//
//            for (int i = 0; i < (heap.size()/2)+1; i++) {
//                v2 = heap.pollFirst();
//            }
//            v1=heap.pollFirst();
//
//            return (((double)v1+(double)v2))/2.0;
//        }
//    }
}
