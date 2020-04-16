package test.com.mesakiiyui.springdatamysql.JUnitTest;

import org.junit.Assert;
import org.junit.Test;

public class TimeOutTest {

//    testTimeOut虽然是死循环，但加了@Test(timeout)参数后还是在2秒运行结束。
//    testException方法没有抛出ArithmeticException，@Test中的expected起作用了。

    @Test(timeout = 2000)
    public void testTimeOut(){
        while (true){
            System.out.println("I'm running!");
            try {
                Thread.sleep(1000 *1);
            } catch (InterruptedException ignore) {
            }
        }
    }

    @Test(expected = ArithmeticException.class)
    public void testException(){
        Assert.assertEquals(3,6/0);
    }
}
