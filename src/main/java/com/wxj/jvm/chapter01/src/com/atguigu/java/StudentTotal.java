package com.wxj.jvm.chapter01.src.com.atguigu.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 项目: JVMDemo
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-03-09 19:35
 **/
public class StudentTotal {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student(1L, 18, 99D);
        Student student2 = new Student(2L, 19, 92D);
        Student student3 = new Student(3L, 15, 91D);
        Student student4 = new Student(4L, 13, 36D);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        students.stream().collect(Collectors.toMap(Student::getId, Function.identity(), (s1, s2) -> {
            s1.setAge(s1.getAge() + s2.getAge());
            s1.setScore(s1.getScore() + s2.getScore());
            return s1;
        })).forEach((k, v) -> System.out.println(k + "-->" + v.toString()));

        System.out.println("=========================");


        Student student = students.stream().reduce(((s1, s2) -> {
//            s1.age += s2.age;
//            s1.score += s2.score;
            s1.setAge(s1.getAge() + s2.getAge());
            s1.setScore(s1.getScore() + s2.getScore());
            return s1;
        })).get();

        System.out.println(student);

    }
}
