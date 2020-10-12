package com.kelvin.leetcode.num71;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    //Not use Stack
    public String simplifyPath1(String path) {
        while(path.contains("//")) {
            path=path.replaceAll("//", "/");
        }
        String[] path_arr = path.split("/");
        if(path_arr.length==0){
            return "/";
        }
        if(path_arr.length==1){
            return "/"+path_arr[0];
        }
        List<String> path_list = new ArrayList();
        for(int i=0;i<path_arr.length;i++){
            if(!path_arr[i].equalsIgnoreCase(".")&&!path_arr[i].equalsIgnoreCase("")){
                path_list.add(path_arr[i]);
            }
        }
        Object[] obj_arr = path_list.toArray();
        path_list = new ArrayList();
        int remove=0;
        for(int i=obj_arr.length-1;i>=0;i--){
            if(String.valueOf(obj_arr[i]).equalsIgnoreCase("..")){
                remove++;
            }else{
                if(remove==0){
                    path_list.add(String.valueOf(obj_arr[i]));
                }else{
                    remove--;
                }
            }

        }
        Collections.reverse(path_list);
        path="/"+String.join("/",path_list);
        return path;
    }

    //Use Stack
    public String simplifyPath(String path) {
        String[] path_arr = path.split("/");
        Stack<String> pathStack = new Stack<String>();
        for(int i=0;i<path_arr.length;i++){
            if(path_arr[i].equalsIgnoreCase(".")||path_arr[i].equalsIgnoreCase("")){
                continue;
            }else if(path_arr[i].equalsIgnoreCase("..")){
                if(!pathStack.empty()){
                    pathStack.pop();
                }
            }else{
                pathStack.push(path_arr[i]);
            }
        }
        if(pathStack.empty()) return "/";

        StringBuffer sb = new StringBuffer();
        while(!pathStack.empty()){
            sb.insert(0,pathStack.pop());
            sb.insert(0,"/");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.simplifyPath("/home/"));
    }
}
