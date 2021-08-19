//package com.wxj.codebaselearn.mianshi;
//
//import lombok.val;
//
//import java.util.*;
//
//public class findTargetStr {
//
//    // ()())() -> ()()() (())
//    // (a)())()  -> (a)()() (a())()
//    // )(
//
//    public List getListStr(String target){
//        List<String> list = new ArrayList();
//
//        if(target == ""){
//            return null;
//        }
//
//        char[] chars = target.toCharArray();
//        Map<Character,Integer > map =  new LinkedHashMap<>();
//
//
//        boolean flag = false;
////        for (int i = 0; i <= chars.length-1;i++){
////            if(!String.valueOf(chars[i]).equals("(") &&
////                    !String.valueOf(chars[i]).equals(")")  ){
////                flag = true;
////            }
////
////
////            if(map.containsKey(chars[i])){
////                map.put(chars[i],map.get(chars[i])+1);
////            }else {
////                map.put(chars[i],1);
////            }
////        }
////
////        //只有括号的
////        if(!flag){
////
////        }
//
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0;i <= chars.length-1;i++){
//            stack.push(chars[i]);
//        }
//
//        for(int i= 0; i<= chars.length-1;i++){
//            Character pop = stack.pop();
//
//        }
//
//    }
//}
