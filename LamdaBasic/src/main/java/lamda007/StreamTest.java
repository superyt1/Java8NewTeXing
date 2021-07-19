package lamda007;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/*
 * 产生stream--》中间操作--》终止操作
 * */
public class StreamTest {
    //创建stream
    @Test
    public void test1(){
        //1可以通过colleation系列集合提供的stream或parallelstream
        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        
        //2通过arrays中的静态方法stream获取数组流
        Student[] students = new Student[10];
        Stream<Student> stream1 = Arrays.stream(students);

        //3通过stream的静态方法of
        Stream<String> stream2 = Stream.of("yit1", "liuwei");

        //4创建无限流
        Stream<Integer> stream3 = Stream.iterate(0,x->x+2);
        Stream<Integer> limit = stream3.limit(100);
        limit.forEach(System.out::println);

    }
}
