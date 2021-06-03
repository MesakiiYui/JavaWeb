package functest.assertDemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jintienan
 * @Date: 2021/4/28 9:35
 */
@Slf4j
public class AssertCollection {

    @Test
    public void notNullTest(){
        List<String> list1 = new ArrayList<>();
        String a  = null;
        Assert.assertNotNull("字符串为空", a);
        log.info("请问我还会执行么？");// 不会
    }
}
