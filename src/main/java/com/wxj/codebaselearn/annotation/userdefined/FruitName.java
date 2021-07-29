package com.wxj.codebaselearn.annotation.userdefined;

import java.lang.annotation.*;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/7/29 0029 9:53
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
