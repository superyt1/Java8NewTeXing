package lamda011;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Test {
    public enum Status{
        FREE,BUSY,VOCATION
    }
    List<Employee> employees = new ArrayList<>();
    List<String> list = new ArrayList<>();
    {
        employees.add(new Employee("1","yit1",28, lamda011.Status.FREE));
        employees.add(new Employee("1","liuwei",26, lamda011.Status.BUSY));
        employees.add(new Employee("1","wujianli",40, lamda011.Status.FREE));
        employees.add(new Employee("1","wujianli",29, lamda011.Status.VOCATION));
        employees.add(new Employee("1","tianyuan",43, lamda011.Status.FREE));
        employees.add(new Employee("1","tianyuan",40, lamda011.Status.BUSY));
    }
    {
        list.add("yit1");
        list.add("liuwei");
        list.add("wujianli");
        list.add("tianyuan");
    }


    /*
     * 终止操作：查找与匹配
     * allmatch
     * anymatch
     * nonematch
     * findfirst
     * count
     * max
     * min
     * */
    @org.junit.Test
    public void test1(){

        //allmatch
        boolean a = employees.stream().allMatch(employee -> employee.status.equals(lamda011.Status.BUSY));
        System.out.println(a);

        //anymatch
        boolean b = employees.stream().anyMatch(employee -> employee.status.equals(lamda011.Status.BUSY));
        System.out.println(b);

        //nonematch
        boolean b1 = employees.stream().noneMatch(employee -> employee.status.equals(lamda011.Status.BUSY));
        System.out.println(b1);

        //findfirst
        Optional<Employee> first = employees.stream().filter(employee -> employee.age > 28).findFirst();
        System.out.println(first.get());

        //findany
        Optional<Employee> any = employees.stream().filter(employee -> employee.age == 40).findAny();
        System.out.println(any);

        //count
        long count = employees.stream().count();
        System.out.println(count);

        //max
        Optional<Employee> max = employees.stream().max((employee1, employee2) -> {
            return employee1.age.compareTo(employee2.age);
        });
        System.out.println(max);

        //min
        Integer age = employees.stream().min((e1, e2) -> {
            return e1.getAge().compareTo(e2.age);
        }).get().getAge();
        System.out.println(age);

        //min ::写法
        Optional<Integer> min = employees.stream().map(Employee::getAge).min(Integer::compareTo);
        System.out.println(min.get());

    }

}
