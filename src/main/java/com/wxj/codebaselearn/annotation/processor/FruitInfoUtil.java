package com.wxj.codebaselearn.annotation.processor;

import com.wxj.codebaselearn.annotation.userdefined.FriutColor;
import com.wxj.codebaselearn.annotation.userdefined.FruitName;
import com.wxj.codebaselearn.annotation.userdefined.FruitProvider;

import java.lang.reflect.Field;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 水果的注解处理器
 * @date 2021/7/29 0029 10:47
 */
public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clazz){

        StringBuffer strFruitName = new StringBuffer("水果名称:\t");
        StringBuffer strFruitColor = new StringBuffer("水果颜色:\t");
        StringBuffer strFruitProvider = new StringBuffer("供应商信息:\n") ;

        Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields) {
            if(field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = field.getAnnotation(FruitName.class);
                strFruitName .append(fruitName.value()) ;
                System.out.println(strFruitName);
            }else if(field.isAnnotationPresent(FriutColor.class)){
                FriutColor friutColor = field.getAnnotation(FriutColor.class);
                strFruitColor.append(friutColor.fruitColor());
                System.out.println(strFruitColor);
            }else if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                strFruitProvider.append("\t供应商编号：").append(fruitProvider.id()).append("\t供应商名称：")
                .append(fruitProvider.name()) .append("\t供应商地址：").append(fruitProvider.address());
                System.out.println(strFruitProvider);
            }
        }



    }
}