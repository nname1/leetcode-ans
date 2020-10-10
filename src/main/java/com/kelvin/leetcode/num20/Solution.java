package com.kelvin.leetcode.num20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='(' || chars[i]=='{' || chars[i]=='[' ){
                stack.push(chars[i]);
            }else {
                if(stack.empty()||stack.pop()!=map.get(chars[i])){
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }else{
            return false;
        }
    }
}
