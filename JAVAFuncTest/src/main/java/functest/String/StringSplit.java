package functest.String;

public class StringSplit {
    public static void main(String[] args) {
        String str = "123123 345345";
        String[] strArr = str.split(" ");
        for(String i : strArr) {
            System.out.println(i);
        }
    }
}
