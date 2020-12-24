package functest.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

/**
 * @Author: jintienan
 * @Date: 2020/10/26 9:17
 */
@Slf4j
public class ConcurrentHashMapTest {

    @Test
    public void generateCcrtMap(){
        Map<Integer, Integer> ccrtMap = new  ConcurrentHashMap();
        ccrtMap.put(1,2);
        ccrtMap.put(3,4);
        Stream.of(ccrtMap.keySet()).forEach(System.out::print);
    }

}
