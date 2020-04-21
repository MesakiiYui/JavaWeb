package functest.nullException;

public class NullExcption {
    private void nullCheck() {
        PeopleNull people = new PeopleNull();
        people.setAge("3213123123");
        if(null != people.getName() && people.getName().equals("xxxx")) {
            System.out.println("aa");
        } else {
            System.out.println("bb");
        }
        if(null == people.getName()) {
            System.out.println("yes, people.age is null");
        }
        setPeople(people);
        System.out.println(people.getAge());
    }
    private void stringConnect() {
        Long x  = 111L;
        String a = "aksbwncw";
        System.out.println(a + x);
    }

    private void objNullCheck() {
        Object obj = new PeopleNull("1", null);

        System.out.println( obj.hashCode());
    }
    private void setPeople(PeopleNull people) {
        people.setAge("7777");
    }
    private void arrayNullCheck() {
        String name = "";

        String[] arr1 = name.split("#");
        for(int i = 0; i < arr1.length; i+= 1) {
            System.out.println("i"+arr1[i]);
        }
    }

    public static void main(String[] args) {
//        NullExcption ne = new NullExcption();
//        ne.nullCheck();
//        ne.stringConnect();
//        ne.objNullCheck();
//        ne.arrayNullCheck();
        String a = null;
        if(null != a){
            System.out.println("yes");
        } else {
            System.out.println("empty");
        }
    }
}
