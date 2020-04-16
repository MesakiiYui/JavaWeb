package test.com.mesakiiyui.springdatamysql.JUnitTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

// 很多时候，我们需要对一个测试，输入多组测试用例来验证代码的正确性。
// 在junit4中，我们不需要编写n个测试方法。示例如下：
@RunWith(Parameterized.class)
public class ParamsTest {
    private int expected;
    private int input1;
    private int input2;

    public ParamsTest(int expected, int input1, int input2){
        this.expected = expected;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> params(){
        return Arrays.asList(new Object[][]{
                {3,2,1},
                {4,1,4}
        });
    }

    @Test
    public void testAdd(){
        Assert.assertEquals("add function",this.expected,this.input1 + this.input2);
    }
}
