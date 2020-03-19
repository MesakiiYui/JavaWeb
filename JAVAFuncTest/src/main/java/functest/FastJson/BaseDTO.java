package functest.FastJson;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class BaseDTO implements Serializable {

    private static final long  serialVersionUID = 2230553030766621644L;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
