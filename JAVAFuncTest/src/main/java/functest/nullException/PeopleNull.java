package functest.nullException;

import lombok.Getter;
import lombok.Setter;
import org.junit.Assert;

public class PeopleNull {
    @Getter @Setter String name;
    @Getter @Setter String age;
    public PeopleNull() {

    }
    public PeopleNull(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
