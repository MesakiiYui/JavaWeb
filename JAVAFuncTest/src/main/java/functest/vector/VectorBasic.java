package functest.vector;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * @Author: jintienan
 * @Date: 2021/4/27 10:59
 */
@Slf4j
public class VectorBasic implements Serializable {


    private static final long serialVersionUID = -7114453857065857785L;

    public static void vectorTest(){
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        Vector<String> vector = new Vector<String>();
        vector.addAll(list1);
        vector.capacity();
        vector.ensureCapacity(3);
        log.info(JSON.toJSONString(vector));

    }

    public static void main(String[] args) {
        vectorTest();
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
    }
}
