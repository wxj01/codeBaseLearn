外部类：

最普通的，我们平时见到的那种类，就是在一个后缀为.java的文件中，直接定义的类，比如

public class Student {
private String name;
private int age;
}

内部类：

内部类，顾名思义，就是包含在外部类中的类，就叫做内部类。内部类有两种，一种是静态内部类，一种是非静态内部类。

public class School {
private static School instance = null;
static class Teacher {}
}

public class School {
private String name;
class Teacher {}
}

静态内部类和非静态内部类之间的区别主要如下：

1、内部原理的区别：

静态内部类是属于外部类的类成员，是一种静态的成员，是属于类的，就有点类似于private static Singleton instance = null；非静态内部类，是属于外部类的实例对象的一个实例成员，也就是说，每个非静态内部类，不是属于外部类的，是属于外部类的每一个实例的，创建非静态内部类的实例以后，非静态内部类实例，是必须跟一个外部类的实例进行关联和有寄存关系的。

2、创建方式的区别：

创建静态内部类的实例的时候，只要直接使用“外部类.内部类()”的方式，就可以，比如new School.Teacher()；创建非静态内部类的实例的时候，必须要先创建一个外部类的实例，然后通过外部类的实例，再来创建内部类的实例，new School().Teader()

通常来说，我们一般都会为了方便，会选择使用静态内部类。

匿名内部类：

public interface ISayHello {
String sayHello(String name);
}

public class SayHelloTest {

public static void main(String[] args) {
ISayHello obj = new ISayHello() {
public String sayHello(String name) { return "hello, " + name }
}
System.out.println(obj.sayHello("leo"))
}

}

匿名内部类的使用场景，通常来说，就是在一个内部类，只要创建一次，使用一次，以后就不再使用的情况下，就可以。那么，此时，通常不会选择在外部创建一个类，而是选择直接创建一个实现了某个接口、或者继承了某个父类的内部类，而且通常是在方法内部，创建一个匿名内部类。

在使用java进行spark编程的时候，如果使用的是java7以及之前的版本，那么通常在对某个RDD执行算子，并传入算子的函数的时候，通常都会传入一个实现了某个Spark Java API中Function接口的匿名内部类。
