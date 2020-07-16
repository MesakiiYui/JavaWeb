package functest.reflection;
class Animal {
    public int location;
    protected int age;
    private int height;
    int length;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}