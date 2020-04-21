<<<<<<< HEAD:JAVAFuncTest/src/main/java/functest/FastJson/TestFastJsonSerialize.java
package functest.FastJson;

import com.alibaba.fastjson.JSON;

import java.util.Date;

public class TestFastJsonSerialize {


    public static void serialize() {
        User user = new User();
        user.setId(11L);
        user.setName("西安");
        user.setCreateTime(new Date());
        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);
    }

    public static void deserialize() {
        String jsonString = "{\"createTime\":\"2018-08-17 14:38:38\",\"id\":11,\"name\":\"西安\"}";
        User user = JSON.parseObject(jsonString, User.class);
        System.out.println(user.getName());
        System.out.println(user.getCreateTime());
    }
    public static void main(String[] args) {
        serialize();
        deserialize();
    }

}
=======
package FastJson;

import com.alibaba.fastjson.JSON;

import java.util.Date;

public class TestFastJsonSerialize {


    public static void serialize() {
        User user = new User();
        user.setId(11L);
        user.setName("西安");
        user.setCreateTime(new Date());
        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);
    }

    public static void deserialize() {
        String jsonString = "{\"createTime\":\"2018-08-17 14:38:38\",\"id\":11,\"name\":\"西安\"}";
        User user = JSON.parseObject(jsonString, User.class);
        System.out.println(user.getName());
        System.out.println(user.getCreateTime());
    }
    public static void main(String[] args) {
        serialize();
        deserialize();
    }

}
>>>>>>> 88753f20a8c6141a51d913abc17cf0994eb3a2b4:JAVAFuncTest/src/main/java/FastJson/TestFastJsonSerialize.java
