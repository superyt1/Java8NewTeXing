package lamda003;

public class Test {
    public Integer operate(Integer num, MyFunc11 func11){
        return func11.getValue(num);//执行具体的实现
    }
    @org.junit.Test
    public void test(){
        Integer operate = operate(100, x -> x * x);
        System.out.println(operate);
    }

}
