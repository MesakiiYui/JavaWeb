package functest.objectParser;

public class ObjectParser {
    private static void changeName(People people){
        people.setName("haha");
    }
    private static void changeString(String ele) {
        ele = "adwcwcwcec";
    }
    public static void main(String[] args) {
        People people = new People();
        people.setAge("1");
        changeName(people);
        System.out.println(people.getName());
        String myStr = "myStr";
        myStr = myStr + "123";
        changeString(myStr);
        System.out.println(myStr);
    }
}
