package functest.javautilimpl;

import lombok.Getter;
import lombok.Setter;

public class People {
    public People(){

    }
    public People(Integer age) {
        this.age = age;
    }
    @Getter
    @Setter
    private Integer age;
}
