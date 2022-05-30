package com.wxj.testSomthing;


import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * @author wxj
 * @version 1.0.0
 * @ClassName TestVector.java
 * @Description TODO
 * @createTime 2022年04月04日 19:31:00
 */


public class TestVector {
    public static void main(String[] args) {

       final Vector<Person> vector = new Vector();
        Person person = new Person();
        person.setName("a");
        vector.add(person);

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            vector.forEach(person1 -> {
                System.out.println("姓名："+person1.getName());
            });
        }).start();

         new Thread(()->{
             Person person1 = vector.get(0);
             person1.setName("b");
             vector.add(person1);
         }).start();

    }

}
class Person{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
