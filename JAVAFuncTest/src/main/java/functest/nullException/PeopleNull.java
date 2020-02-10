package functest.nullException;

import org.junit.Assert;

public class PeopleNull {
    String name;
    String age;
    public PeopleNull() {

    }
    public PeopleNull(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (null == name) {
            this.name = "xxxx";
        }else {
            this.name = name;
        }

    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
