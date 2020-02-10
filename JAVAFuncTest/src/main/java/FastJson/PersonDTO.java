package FastJson;

public class PersonDTO extends BaseDTO{
    private static final long serialVersionUID = 4637634512292751986L;

    private int id;
    private int age;
    private String name;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
