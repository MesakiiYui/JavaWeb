package functest.javautilimpl;

public class People {
    public People(){

    }
    public People(Integer age) {
        this.age = age;
    }
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
