<<<<<<< HEAD:JAVAFuncTest/src/main/java/functest/FastJson/BaseDTO.java
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
=======
package FastJson;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class BaseDTO implements Serializable {

    private static final long  serialVersionUID = 2230553030766621644L;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
>>>>>>> 88753f20a8c6141a51d913abc17cf0994eb3a2b4:JAVAFuncTest/src/main/java/FastJson/BaseDTO.java
