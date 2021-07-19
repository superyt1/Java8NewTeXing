package lamda008;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class Test {
    List<Employee> list = new ArrayList<>();
    {
        list.add(new Employee("1","yit1",28));
        list.add(new Employee("1","liuwei",26));
        list.add(new Employee("1","wujianli",29));
        list.add(new Employee("1","wujianli",29));
        list.add(new Employee("1","tianyuan",40));
        list.add(new Employee("1","tianyuan",40));
    }

    /*
     * 中间操作
     * 筛选与切面
     * filter：接收lamda表达式，从流中删除某些元素
     * limit(n):使其元素不超过给定数量
     * skip(n):扔掉前n个
     * distinct：通过流中所生成元素的hashcode和equals去除重复元素
     * */
    @org.junit.Test
    public void test1(){
        Stream<Employee> stream = list.stream();
        Stream<Employee> employeeStream = stream.filter(employee -> employee.age > 27);
        employeeStream.forEach(employee -> System.out.println(employee));

    }
    @org.junit.Test
    public void test2(){
        list.stream().filter(employee -> employee.age>18).limit(2).forEach(System.out::println);
    }
    @org.junit.Test
    public void test3(){
        list.stream().filter(employee -> employee.age>26).skip(2).forEach(System.out::println);
    }
    @org.junit.Test
    public void test4(){
        list.stream().filter(employee -> employee.age>26).distinct().forEach(System.out::println);
    }

}
