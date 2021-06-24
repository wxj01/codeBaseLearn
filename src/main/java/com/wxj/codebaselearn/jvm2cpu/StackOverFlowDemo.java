package com.wxj.codebaselearn.jvm2cpu;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO StackOverflowError
 *
 * 这里用到例子是 https://blog.csdn.net/gentlezuo/article/details/90580116，感谢
 *
 * 走了一下断点 ，会循环不断调用 student 和 book 的toString() 方法。
 * 放开断点后：报StackOverFlowDemo
 *
 * @date 2021/4/23 0023 15:58
 */
//book和student相互循环引用
public class StackOverFlowDemo {

    static class Student{
        String name;
        Book book;

        public Student(String name) {
            this.name = name;
        }
        //循环调用toString方法
        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", book=" + book +
                    '}';
        }
    }

    static class Book {
        String isbn;
        Student student;

        public Book(String isbn, Student student) {
            this.isbn = isbn;
            this.student = student;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "isbn='" + isbn + '\'' +
                    ", student=" + student +
                    '}';
        }
    }

    public static void main(String[] args) {
        Student student=new Student("zhang3");
        Book book=new Book("1111",student);
        student.book=book;
        System.out.println(book.toString());
    }

}
//————————————————
//        原文链接：https://blog.csdn.net/gentlezuo/article/details/90580116