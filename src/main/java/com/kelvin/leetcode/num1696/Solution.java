package com.kelvin.leetcode.num1696;

public class Solution {

    public int[] singleNumbers(int[] nums) {
        int[] ans = new int[2];
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];
        }
        int x=0,y=0;
        int n=0;
        while((xor=xor >> 1)>0){
            n++;
        }
        for(int i=0;i<nums.length;i++){
            int result = (nums[i]>>n)&1;
            if( result == 1){
                x^=nums[i];
            }else{
                y^=nums[i];
            }
            xor^=nums[i];
        }
        ans[0]=x;
        ans[1]=y;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,5,8,8,9,9,12,11,13,11,12,13};
        Solution s = new Solution();
        int[] res = s.singleNumbers(arr);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
