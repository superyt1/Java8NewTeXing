package lamda009;



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
     * 映射:
     * map
     * flatmap
     * */
    @org.junit.Test
    public void test1(){
        list.stream().map(employee -> {
            String s = employee.name.toUpperCase();
            employee.setName(s);
            return employee;
        }).forEach(System.out::println);

        System.out.println("---------------------------");
        list.stream().map(employee -> employee.getName()).forEach(System.out::println);
        list.stream().map(Employee::getName).forEach(System.out::println);


    }

}
