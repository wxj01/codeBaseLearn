package com.wxj.codebaselearn.ms;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 模拟 this 逃逸的问题
 * 引用原作者 博客https://www.cnblogs.com/jian0110/p/9369096.html，特此标注。
 *
 * this 逃逸的问题，因看到 可见性(Visibility) 的中
 * final 可见性是指：被 final 修饰的字段在构造器中一旦完成，
 * 并且构造器没有把 “this” 的引用传递出去( this 引用逃逸是一件很危险的事情，其他线程有可能通过这个引用访问到“初始化了一半”的对象)，
 * 那在其他线程中就能看见 final 字段的值。
 *
 * @date 2021/4/30 0030 10:25
 */
public class ThisEscape {
    //final常量会保证在构造器内完成初始化（但是仅限于未发生this逃逸的情况下，具体可以看多线程对final保证可见性的实现）
    final int i;
    //尽管实例变量有初始值，但是还实例化完成
    int j = 0;
    static ThisEscape obj;

    public ThisEscape() {
        i = 1;
        j = 1;
        //将this逃逸抛出给线程B
        obj = this;
    }

    public static void main(String[] args) {
        //线程A：模拟构造器中this逃逸,将未构造完全对象引用抛出
         /*Thread threadA = new Thread(new Runnable() {
             @Override
             public void run() {
                 //obj = new ThisEscape();
             }
         });*/
        //线程B：读取对象引用，访问i/j变量
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                //可能会发生初始化失败的情况解释：实例变量i的初始化被重排序到构造器外，此时1还未被初始化
                ThisEscape objB = obj;
                try {
                    System.out.println(objB.j);
                } catch (NullPointerException e) {
                    System.out.println("发生空指针错误：普通变量j未被初始化");
                }
                try {
                    System.out.println(objB.i);
                } catch (NullPointerException e) {
                    System.out.println("发生空指针错误：final变量i未被初始化");
                }
            }
        });
        //threadA.start();
        threadB.start();
    }
}