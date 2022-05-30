package com.wxj.codebaselearn.list;

import java.util.Iterator;
import java.util.List;

public class User {
    private Integer age;
    private Integer getAge(){return age;}

    public static void remove(List<User> userList){

        if(userList != null && userList.size() > 0){
            Iterator<User> iterator = userList.iterator();
            while (iterator.hasNext()){
                User user = iterator.next();
                if(user != null && user.getAge() > 20){
                    iterator.remove();
                }
            }
        }
    }
}
