package lamda006;

import java.util.Comparator;
import java.util.function.*;

/*
* 一、方法引用：若lamda体中的内容有方法已经实现了，我们就可以使用方法引用
*
* 主要有三种语法格式
* 对象：：实例方法名
* 类：：静态方法名
* 类：：实例方法名
*
* 二、构造器引用
* 格式:className::new
* */
public class Test {

    /*
     * 构造器引用
     *
     * */
    @org.junit.Test
    public void test5(){
        Supplier<Student> supplier = ()->new Student();
        Student student = supplier.get();
        System.out.println(student);

        //构造器引用,无参构造器
        Supplier<Student> supplier1 = Student::new;
        System.out.println(supplier1.toString());


        //构造器引用，有参构造器，一个参数的
        Function<String,Student> function = value -> new Student(value);
        Student liuwei = function.apply("liuwei");
        System.out.println(liuwei.toString());

        Function<String,Student> function1 = Student::new;
        System.out.println(function1.apply("yit1"));


        //构造器引用，有参构造器，两个参数的
        BiFunction<String,Integer,Student> biFunction = Student::new;
        System.out.println(biFunction.apply("yit1",19));
    }   
    /*
     * 类：：实例方法
     * */
    @org.junit.Test
    public void test4(){
        BiPredicate<String,String> biPredicate = (x,y)->x.equals(y);
        boolean test = biPredicate.test("1", "2");
        System.out.println(test);

        BiPredicate<String,String> biPredicate1 = String::equals;//若lamda参数列表中的第一个参数是实例方法的调用者，第二哥参数是实例方法的参数时，可以使用className::method
        boolean test1 = biPredicate1.test("1", "1");
        System.out.println(test1);

    }
    
    
    
    
    /*
    * 类：：静态方法
    * */
    @org.junit.Test
    public void test3(){
        Comparator<Integer> comparator = (x,y)->Integer.compare(x,y);
        Comparator<Integer> comparator1 = Integer::compare;
        int compare = comparator1.compare(1, 2);
        System.out.println(compare);
    }






    /*
    * 对象：：实例化方法
    * */
    @org.junit.Test
    public void test1(){
        Consumer consumer = System.out::println;
        consumer.accept("yit1");
    }
    @org.junit.Test
    public void test2(){
        Student student = new Student();
        student.setName("yit1");
        Supplier<String> supplier = student::getName;
        String name = supplier.get();
        System.out.println(name);
    }


}
