package functest.nowcoder;

public class TestClass {
    public TestClass(Integer a) {
        this.a = a;
    }
    static Integer a =1;
    public static void main(String[] args) {
        String a = "hello";
        String b = "hello";
        System.out.println(a==b);
        char c[] ={'h', 'e', 'l', 'l', 'o'};
        System.out.println(c.equals(b));
        TestClass testC = new TestClass(2);
        char str = '\n';
        char str2 = '\123';
        Object obj = new Object();
    }
}
class Demo {
    class Super{
        int flag=1;
        Super(){
            test();
        }
        void test(){
            System.out.println("Super.runoob.test() flag="+flag);
        }
    }
    class Sub extends Super{
        Sub(int i){
            flag=i;
            System.out.println("Sub.Sub()flag="+flag);
        }
        void test(){
            System.out.println("Sub.runoob.test()flag="+flag);
        }
    }
    public static void main(String[] args) {
        new Demo().new Sub(5);
    }
}
