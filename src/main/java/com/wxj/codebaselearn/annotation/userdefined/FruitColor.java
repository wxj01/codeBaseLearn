package com.wxj.codebaselearn.annotation.userdefined;

import java.lang.annotation.*;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/7/29 0029 9:55
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    
    /** 
     * @description: 颜色
     * @param: * @param: null 
     * @return:  
     * @author wangxinjian
     * @date: 2021/7/29 0029 9:56
     */ 
    public enum Color{YELLOW,RED,GREEN}


    Color fruitColor() default Color.YELLOW;
}
