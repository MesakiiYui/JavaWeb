package functest.jsonParser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.util.List;

/**
 * @Author: jintienan
 * @Date: 2021/6/1 10:49
 */
@Slf4j
public class FastJsonTest{

    @Test
    public void testJsonParser(){
        String jsonStr = "{\"result\":\"0\",\"resultCode\":\"0100000\",\"resultDesc\":[{\"agentId\":101,\"groupId\":-1,\"rights\":\"[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]\",\"name\":\"HW50333101\",\"realFlag\":1},{\"agentId\":102,\"groupId\":-1,\"rights\":\"[1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]\",\"name\":\"102\",\"realFlag\":1},{\"agentId\":107,\"groupId\":-1,\"rights\":\"[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]\",\"name\":\"HW13360107\",\"realFlag\":1}]}";
        ApiResponse<List<AgentStaticConfInfoResponse>> res = JSON.parseObject(jsonStr, new TypeReference<ApiResponse<List<AgentStaticConfInfoResponse>>>(){});
        log.info("解析后的数据:"+ JSON.toJSONString(res));
    }

}
