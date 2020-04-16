package test.com.mesakiiyui.springdatamysql.JUnitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//测试suite就是组织测试类一起运行；
//写一个作为测试suite的入口类。这个类不包含任何方法;
//更改suite入口类的测试运行器为Suite.class;
//将要运行的测试类作为数组传入到@Suite.SuiteClasses({})中。
@RunWith(Suite.class)
@Suite.SuiteClasses({CommonTest.class,TimeOutTest.class})
public class SuiteTest {


}
