<<<<<<< HEAD:JAVAFuncTest/src/main/java/functest/FastJson/User.java
package functest.FastJson;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User {

    private Long   id;

    private String name;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date   createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

=======
package FastJson;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User {

    private Long   id;

    private String name;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date   createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

>>>>>>> 88753f20a8c6141a51d913abc17cf0994eb3a2b4:JAVAFuncTest/src/main/java/FastJson/User.java
}