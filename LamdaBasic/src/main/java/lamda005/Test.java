package lamda005;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*java8四大内置核心函数式接口
* 1消费性接口
* 2供给型接口
* 3函数型接口
* 4断言型接口
* */
public class Test {
    //consumer方法
    @org.junit.Test
    public void test1(){
        testConsumer("yit1",value -> System.out.println((value).toUpperCase()));
    }
    public void testConsumer(String value, Consumer<String> consumer){
        consumer.accept(value);
    }

    //supplier方法
    @org.junit.Test
    public void test2(){
        testSupplier(1,()->1000);
        testSupplier(2,()->2000);
    }
    public void testSupplier(int value, Supplier<Integer> supplier){
        Integer n = supplier.get();
        System.out.println(n);

    }

    //function方法
    @org.junit.Test
    public void test3(){
        testFunction("yit1",value->value.toUpperCase());

    }
    public void testFunction(String value, Function<String,String> function){
        String res = function.apply(value);
        System.out.println(res+"yit1");
    }

    //predicate
    //将指满足条件的字符串放入到集合中
    @org.junit.Test
    public void test4(){
        List list = new ArrayList();
        list.add("yit1");
        list.add("wujl2");
        list.add("liuh3");
        list.add("yif2");
        List res = testPredicate(list, value -> value.length() == 4);
        System.out.println(res.toString());
        System.out.println(testPredicate(list,value->value.length()==5));
    }
    public List<String> testPredicate(List<String> list, Predicate<String> predicate){
        List<String> res = new ArrayList<>();
        for (String temp:
             list) {
            boolean flag = predicate.test(temp);
            if (flag) res.add(temp);
        }
        return res;
    }

}
