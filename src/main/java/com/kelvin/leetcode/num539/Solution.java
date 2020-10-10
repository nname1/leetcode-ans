package com.kelvin.leetcode.num539;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //不排序解法
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        int min=60*12;
        BTree root = null;
        for(int i=0;i<timePoints.size();i++){
            if(i==0){
                root = new BTree(timePoints.get(i));
            }else{
                min=Math.min(root.calculateMin(new BTree(timePoints.get(i)),min),min);
            }
        }
        int gap = root.getMostRightTime()-root.getMostLeftTime();
        if (gap > 60 * 12) {
            gap=1440-gap;
        }
        min=Math.min(gap,min);
        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> list = new ArrayList<String>();
        list.add("19:56");
        list.add("03:10");
        list.add("10:10");
        list.add("15:55");
        list.add("11:27");
        list.add("13:25");
        list.add("05:31");
        list.add("04:11");
        list.add("01:09");
        list.add("10:43");
        System.out.println(s.findMinDifference(list));
    }

    private class BTree{
        String clock;
        BTree left;
        BTree right;
        public BTree(String clock){
            this.clock=clock;
        }
        public int calculateMin(BTree bTree,int minMin){
            int hour = Integer.parseInt(bTree.clock.split(":")[0]);
            int min = Integer.parseInt(bTree.clock.split(":")[1]);
            int hour0=Integer.parseInt(clock.split(":")[0]);
            int min0=Integer.parseInt(clock.split(":")[1]);
            int gap=1440;
            if(hour<hour0||(hour==hour0&&min<min0)){
                gap= (hour0 * 60 + min0) - (hour * 60 + min);
                if (gap > 60 * 12) {
                    gap=1440-gap;
                }
                minMin=Math.min(gap,minMin);
                if(left==null){
                    left=bTree;
                }else{
                    return left.calculateMin(bTree,minMin);
                }
            }else if(hour>hour0||(hour==hour0&&min>min0)){
                gap= (hour * 60 + min) - (hour0 * 60 + min0);
                if (gap > 60 * 12) {
                    gap=1440-gap;
                }
                minMin=Math.min(gap,minMin);
                if(right==null){
                    right=bTree;
                }else{
                    return right.calculateMin(bTree,minMin);
                }
            }else{
                return 0;
            }
            return minMin;
        }

        public int getMostLeftTime(){
            if(left == null){
                return (Integer.parseInt(this.clock.split(":")[0])*60+Integer.parseInt(this.clock.split(":")[1]));
            }else{
                return left.getMostLeftTime();
            }
        }

        public int getMostRightTime(){
            if(right == null){
                return (Integer.parseInt(this.clock.split(":")[0])*60+Integer.parseInt(this.clock.split(":")[1]));
            }else{
                return right.getMostRightTime();
            }
        }
    }
}
