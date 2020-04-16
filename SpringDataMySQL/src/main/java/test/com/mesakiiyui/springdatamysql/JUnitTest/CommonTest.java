package test.com.mesakiiyui.springdatamysql.JUnitTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CommonTest {

//    测试方法上必须使用@Test进行修饰;
//    测试方法必须使用public void 进行修饰，不能待任何的参数;
//    测试单元中的每个方法必须可以独立测试，测试方法间不能有任何的依赖;
//    测试类使用Test作为类名的后缀(可选);
//    测试方法使用test作为方法名的前缀(可选);

    @BeforeClass
    public static void init(){
        System.out.println("test class before");
    }

    @AfterClass
    public static void destory(){
        System.out.println("test class after");
    }

    @Before
    public void beforeTest(){
        System.out.println("before test");
    }

    @After
    public void afterTest(){
        System.out.println("after test");
    }

    @Test
    public void testAdd(){
        Assert.assertEquals("test add", 3, 1 + 2);
        System.out.println("test add ok");
    }

    @Test
    public void testSub(){
        Assert.assertEquals("test subtraction", 3, 4 - 1);
        System.out.println("test sub ok");
    }
}
