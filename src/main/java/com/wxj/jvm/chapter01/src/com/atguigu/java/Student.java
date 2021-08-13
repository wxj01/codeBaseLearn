package com.wxj.jvm.chapter01.src.com.atguigu.java;

/**
 * 项目: JVMDemo
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-03-09 19:34
 **/
public class Student {
    public Long id;

    public Integer age;

    public Double score;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    public Student(Long id) {
        this.id = id;
    }

    public Student(Long id, Integer age, Double score) {
        this.id = id;
        this.age = age;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
