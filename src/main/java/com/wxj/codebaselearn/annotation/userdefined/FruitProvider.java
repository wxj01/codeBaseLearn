package com.wxj.codebaselearn.annotation.userdefined;

import java.lang.annotation.*;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/7/29 0029 10:04
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider{


    /** 
     * @description: 供应编号 
     * @param: * @param:  
     * @return: int 
     * @author wangxinjian
     * @date: 2021/7/29 0029 10:06
     */ 
    public int id() default -1;
    
    /** 
     * @description: 供应商名称 
     * @param: * @param:  
     * @return: java.lang.String 
     * @author wangxinjian
     * @date: 2021/7/29 0029 10:06
     */ 
    public String name() default "";
    
    
    /** 
     * @description: 供应商地址
     * @param: * @param:  
     * @return: java.lang.String 
     * @author wangxinjian
     * @date: 2021/7/29 0029 10:42
     */ 
    public String address() default "";
}
