package lamda010;



import java.util.ArrayList;
import java.util.List;


public class Test {
    List<Employee> employees = new ArrayList<>();
    List<String> list = new ArrayList<>();
    {
        employees.add(new Employee("1","yit1",28));
        employees.add(new Employee("1","liuwei",26));
        employees.add(new Employee("1","wujianli",40));
        employees.add(new Employee("1","wujianli",29));
        employees.add(new Employee("1","tianyuan",43));
        employees.add(new Employee("1","tianyuan",40));
    }
    {
        list.add("yit1");
        list.add("liuwei");
        list.add("wujianli");
        list.add("tianyuan");
    }


    /*
     * 中间操作
     * 排序
     * sorted:自然排序
     * sorted(Comparator com)--定制排序
     * */
    @org.junit.Test
    public void test1(){
        list.stream().sorted().forEach(System.out::println);
        System.out.println("---------------------------");
        employees.stream().sorted((e1,e2)->{
            if (e1.getName().equals(e2.getName())) {
                return e1.getAge().compareTo(e2.getAge());
            }else{
                return e1.getName().compareTo(e2.getName());
            }
        }).forEach(System.out::println);

    }

}
