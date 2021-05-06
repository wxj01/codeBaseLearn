package com.wxj.SecureRandom;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SecureRandomDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException {
//        demo1();
//        demo2();
        demo3();
//        demo4();
    }


    private static void demo1() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int intValue = Double.valueOf(Math.random() * 1000000).intValue();
            String random = String.valueOf(intValue);
            String r = (random.length() == 6 && "9".equals(random.substring(0, 1))) ? random : String.valueOf(intValue + 100000);
            list.add(r);
        }
        Collections.sort(list);
        list.forEach(System.out::println);
    }

    private static void demo2() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Random random1 = new Random();
            list.add(random1.nextInt(900000) + 100000);
        }
        Collections.sort(list);
        list.forEach(System.out::println);
    }

    private static void demo3() throws NoSuchAlgorithmException {
        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < 1000000; i++) {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            String v = String.valueOf(secureRandom.nextInt(900000) + 100000);

            if(v.length() != 6){
                System.out.println("长度不是6 位");
//                break;
//            }

            list.add(v);
        }
        Collections.sort(list);
        list.forEach(System.out::println);
    }


    private static void demo4() throws NoSuchAlgorithmException {
        //验证SecureRandom
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            SecureRandom random3 = SecureRandom.getInstance("SHA1PRNG");
            //生成10位数的随机数
            Integer r = random3.nextInt();
            //生成0~99的随机数
            Integer r2 = random3.nextInt(100);
            list.add(r2);
        }
        Collections.sort(list);
        list.forEach(System.out::println);
    }

}
