package Test;

public interface Inter {
    static String name = "yit1";
    static public void test1(){
        System.out.println("static test1");
    }
    default public void test2(){
        System.out.println("defalut test2");
    }
    void test3();
}
