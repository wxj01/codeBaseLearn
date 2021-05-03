package com.wxj.codebaselearn.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *  启动的时候报：Exception in thread "main" java.lang.NoSuchMethodError:
 *  org.springframework.beans.factory.config.ConfigurableListableBeanFactory.getApplicationStartup()Lorg/springframework/core/metrics/ApplicationStartup;
 *
 *  问题是：pom 中引入 activemq-all自带的包和我项目的spring包冲突了，我在测试spirng 的循环依赖的时候直接报错了，jar 冲突了
 *
 *  spring 的 DefaultSingletonBeanRegistry 中的三級缓存
 *  1.singletonObjects      一级缓存
 *  2.earlySingletonObjects 二级缓存
 *  3.singletonFactories    三级缓存
 */

// DefaultSingletonBeanRegistry extends SimpleAliasRegistry implements SingletonBeanRegistry
    /** Cache of singleton objects: bean name to bean instance.  */
//    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

    /** Cache of singleton factories: bean name to ObjectFactory. */
//    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>(16);

    /** Cache of early singleton objects: bean name to bean instance.  */
//    private final Map<String, Object> earlySingletonObjects = new ConcurrentHashMap<>(16);

public class ClientSpringContainer {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        A a = context.getBean(A.class);
        B b = context.getBean(B.class);
    }
}
