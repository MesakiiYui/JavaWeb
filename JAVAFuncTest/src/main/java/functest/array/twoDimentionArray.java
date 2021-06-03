package functest.array;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.analysis.function.Max;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class twoDimentionArray {
    public static void main(String[] args) {
        String[][] arr = new String[2][];
        List <List< String >> res = new ArrayList<>();
        int[][] ar = new int[3][3];
        log.info(JSON.toJSONString(ar.length));
        log.info(JSON.toJSONString(ar));
        int[] ele = new int[]{1,2};
        ar[0] = ele;
        log.info(JSON.toJSONString(ar.length));
        log.info(JSON.toJSONString(ar));

    }


}
