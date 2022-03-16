package com.wxj.testSomthing;

import org.junit.Test;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2022/2/17 0017 9:43
 */
public class TestModAndRemainder {

    @Test
    public void test(){
//        int base = 3;
//        int num1 = 1,num2 = 3,num3 = 4,
//                num4 = 6,num5 = 7,num6 = 8,num7 = 9,num8 = 10;
        double base = 3;
        double num1 = 1,num2 = 3,num3 = 4,
                num4 = 6,num5 = 7,num6 = 8,num7 = 9,num8 = 10;

        System.out.println("--------取模--------");
        System.out.println(num1 % base );
        System.out.println(num2 % base );
        System.out.println(num3 % base );

        System.out.println("--------取余---------");

        System.out.println(num1 / base );
        System.out.println(num2 / base );
        System.out.println(num3 / base );

        System.out.println("-----getNumber---------");
        System.out.println(getNumber(num1 , base) );  //1
        System.out.println(getNumber(num2 , base) );  //1
        System.out.println(getNumber(num3 , base) );  //2
        System.out.println(getNumber(num4 , base) );  //2
        System.out.println(getNumber(num5 , base) );  //3
        System.out.println(getNumber(num6 , base) );  //3
        System.out.println(getNumber(num7 , base) );  //3
        System.out.println(getNumber(num8 , base) );  //4


        System.out.println();
    }

    public static int getNumber(int num,int base){
        return num%base == 0 ? num/base : 1 + num/base ;
    }

    public static double getNumber(double num,double base){
        return num%base == 0 ? num/base : 1 + num/base ;
    }
}