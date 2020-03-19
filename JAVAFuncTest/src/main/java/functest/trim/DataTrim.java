package functest.trim;

import functest.listcopy.People;

public class DataTrim {
    public static void main(String[] args) {
        People people = new People();
        String name = people.getName().trim();
        System.out.println(name);
    }
}
