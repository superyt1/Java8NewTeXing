package lamda004;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test {
    List<Employee> list = Arrays.asList(
            new Employee("1","yit1",18,"2000"),
            new Employee("2","wujl",29,"5000"),
            new Employee("3","liuh",20,"800"),
            new Employee("4","yif2",17,"1600")
            );
    @org.junit.Test
    public void test1(){
        Collections.sort(list,(e1,e2)->{
            return e1.getAge().compareTo(e2.getAge());
        });
        for (Employee emploee:list //增强for循环
             ) {
            System.out.println(emploee.age);
        }
    }
    @org.junit.Test
    public void test2(){
        String handleredStr = strHandler("yit1", str -> str.toUpperCase());
        System.out.println(handleredStr);

    }
    public String strHandler(String value,MyFunc11 myFunc11){
        return myFunc11.strHandler(value);
    }
}
