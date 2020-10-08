package com.kelvin.leetcode.num3;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    //效率不高
    public int lengthOfLongestSubstring1(String s) {
        char[] chars = s.toCharArray();
        List<Character> sublist = new ArrayList<>();
        int max=0;
        for(int i=0;i<chars.length;i++){
            for(int j=0;j<sublist.size();j++){
                if(sublist.size()==0){
                    break;
                }
                if(sublist.get(j) == chars[i]){
                    sublist = sublist.subList(j+1,sublist.size());
                    break;
                }else{
                    continue;
                }
            }
            sublist.add(chars[i]);
            max = Math.max(max,sublist.size());
        }
        return max;
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length(); int ans = 0;
        for(int start=0, end=0;end<n;end++){
            if(map.containsKey(s.charAt(end))){
                start = Math.max(map.get(s.charAt(end)),start);
            }
            map.put(s.charAt(end),end+1);
            ans = Math.max(ans,end-start+1);

        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("aoneoahbdlasmpfihwwpfdos"));
    }
}
