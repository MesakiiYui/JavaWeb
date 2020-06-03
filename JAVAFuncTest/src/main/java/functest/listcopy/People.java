package functest.listcopy;

import lombok.Getter;
import lombok.Setter;

public class People {
    @Getter @Setter private String name;
    @Getter @Setter private Integer age;
    public People(){

    }

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
