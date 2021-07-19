package lamda012;



import java.util.*;
import java.util.stream.Collectors;


public class Test {
    public enum Status{
        FREE,BUSY,VOCATION
    }
    List<Employee> employees = new ArrayList<>();
    List<String> list = new ArrayList<>();
    {
        employees.add(new Employee("1","yit1",28, lamda012.Status.FREE));
        employees.add(new Employee("2","liuwei",26, lamda012.Status.BUSY));
        employees.add(new Employee("3","wujianli",40, lamda012.Status.FREE));
        employees.add(new Employee("4","wujianli",29, lamda012.Status.VOCATION));
        employees.add(new Employee("5","tianyuan",43, lamda012.Status.FREE));
        employees.add(new Employee("6","tianyuan",43, lamda012.Status.FREE));
        employees.add(new Employee("7","tianyuan",40, lamda012.Status.BUSY));
        employees.add(new Employee("8","liuwei",26, lamda012.Status.BUSY));
    }
    {
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
    }



    /*
     *终止操作：归约reduce
     *  */
    @org.junit.Test
    public void test1(){
        String reduce = list.stream().reduce("", (x, y) -> x + y);
        System.out.println(reduce);

        System.out.println("----------------------");

        Optional<Integer> reduce1 = employees.stream().map(Employee::getAge).reduce((x, y) -> x + y);
        System.out.println(reduce1.get());
    }


    /*
     *终止操作：收集
     *  */
    @org.junit.Test
    public void test2(){
        //收集list
        List<String> collect = employees.stream()
                .map(Employee::getName).collect(Collectors.toList());
        System.out.println(collect);
        collect.forEach(System.out::println);

        System.out.println("------------------------------");

        //收集set
        Set<String> collect1 = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        collect1.forEach(System.out::println);

        //收集hashset
        HashSet<String> collect2 = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(collect2);

        //收集stream个数
        Long collect3 = employees.stream()
                .collect(Collectors.counting());
        System.out.println(collect3);

        //收集平均值
        Double collect4 = employees.stream().collect(Collectors.averagingInt(Employee::getAge));
        System.out.println(collect4);

        //收集总和
        Integer collect5 = employees.stream().collect(Collectors.summingInt(Employee::getAge));
        System.out.println(collect5);

        //收集最大
        Optional<Employee> collect6 = employees.stream().collect(Collectors.maxBy((e1, e2) -> e1.getAge().compareTo(e2.getAge())));
        System.out.println(collect6.get());

        //收集最小
        Optional<Employee> collect7 = employees.stream().collect(Collectors.minBy((e1, e2) -> e1.getAge().compareTo(e2.getAge())));
        System.out.println(collect7.get());

        //一级分组
        Map<lamda012.Status, List<Employee>> collect8 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(collect8);

        //多级分组
        Map<lamda012.Status, Map<Integer, List<Employee>>> collect9 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(Employee::getAge)));
        System.out.println(collect9);

        //分区
        Map<Boolean, List<Employee>> collect10 = employees.stream()
                .collect(Collectors.partitioningBy(employee -> employee.age > 29));
        System.out.println(collect10);

        //数据分析
        IntSummaryStatistics collect11 = employees.stream()
                .collect(Collectors.summarizingInt(Employee::getAge));
        long sum = collect11.getSum();
        int max = collect11.getMax();
        double average = collect11.getAverage();
        long count = collect11.getCount();
        int min = collect11.getMin();
        System.out.println(sum);
        System.out.println(max);
        System.out.println(average);
        System.out.println(count);
        System.out.println(min);
        
        //连接join
        String collect12 = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining());
        System.out.println(collect12);

        //","字符连接join
        String collect13 = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(collect13);

    }



}
