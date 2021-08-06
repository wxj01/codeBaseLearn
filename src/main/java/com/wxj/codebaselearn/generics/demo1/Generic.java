package com.wxj.codebaselearn.generics.demo1;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 泛型学习
 * @date 2021/8/5 0005 9:32
 */


//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
public class Generic<T> {

    private T key;

    //泛型构造方法形参key的类型也为T，T的类型由外部指定
    public Generic(T key) {
        this.key = key;
    }

    //泛型方法getKey的返回值类型为T，T的类型由外部指定
    public T getKey() {
        return key;
    }

    public static void main(String[] args) {

        //泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
        //传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        Generic<Integer> integerGeneric = new Generic<>(1234);

        //传入的实参类型需与泛型的类型参数类型相同，即为String
        Generic<String> stringGeneric = new Generic<>("abc");

        System.out.println(integerGeneric.getKey());
        System.out.println(stringGeneric.getKey());


        Generic generic = new Generic("111111");
        Generic generic1 = new Generic(4444);
        Generic generic2 = new Generic(55.55);
        Generic generic3 = new Generic(false);

        System.out.println(generic.getKey());
        System.out.println(generic1.getKey());
        System.out.println(generic2.getKey());
        System.out.println(generic3.getKey());



        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Number> gNumber = new Generic<Number>(456);

//        showKeyValue1(gInteger);//Change 1st parameter of method 'showKeyValue1' from 'Generic<Number>' to 'Generic<Integer>'
        showKeyValue1(gNumber);


        try {
            Object obj = genericMethod(Class.forName("com.test.test"));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static void showKeyValue1(Generic<Number> obj){
        System.out.println(obj.getKey());
    }

    /**
     * @description:
     * 类型通配符一般是使用？代替具体的类型实参，注意了，此处’？’是类型实参，而不是类型形参 。
     * 重要说三遍！此处’？’是类型实参，而不是类型形参 ！ 此处’？’是类型实参，而不是类型形参 ！
     * 再直白点的意思就是，此处的？和Number、String、Integer一样都是一种实际的类型，可以把？看成所有类型的父类。是一种真实的类型。
     *
     * 可以解决当具体类型不确定的时候，这个通配符就是 ?  ；当操作类型时，不需要使用类型的具体功能时，只使用Object类中的功能。那么可以用 ? 通配符来表未知类型。
     *
     * @param: * @param: obj
     * @return: void
     * @author wangxinjian
     * @date: 2021/8/5 0005 10:14
     */
    public static void showKeyValue2(Generic<?> obj){
        System.out.println(obj.getKey());
    }

    /**
     * 泛型方法的基本介绍
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public static  <T> T genericMethod(Class<T> tClass)throws InstantiationException ,
            IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
    }


}