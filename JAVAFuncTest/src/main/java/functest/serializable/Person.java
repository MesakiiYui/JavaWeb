package functest.serializable;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter @Setter private Man man;
    @Getter @Setter private String username;
    @Getter @Setter private String name;
    @Getter @Setter private transient int age;
    //  @Setter(AccessLevel.PROTECTED) private string name;



    public Person() {
        System.out.println("person constru");
    }

    public Person(Man man, String username, int age) {
        this.man = man;
        this.username = username;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }
}
