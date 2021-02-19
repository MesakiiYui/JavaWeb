package functest.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MyException {
    private void FilenotFoundDemo() throws RuntimeException {
        File file = new File("E://file.txt");
        String a = "a";
        try{
            FileReader fr = new FileReader(file);
            a = a + "b";
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
            a = a + "c";
        }
        System.out.println(a);
        throw new RuntimeException("这是异常");
    }
    public static void main(String[] args) {
        MyException me = new MyException();
        me.FilenotFoundDemo();
    }
}
