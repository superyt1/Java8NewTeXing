package Test;


public class Test implements Inter{
    public static void main(String[] args) {
        Inter.test1();
        final String name = Inter.name;
    }

    @Override
    public void test3() {

    }
}



/*总结：接口只看得到static变量和方法，实例对象只看得到非static的方法和属性*/
