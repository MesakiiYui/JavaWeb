package functest.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList{
    private  void  arrayInit() {
        List<String> name1 = Arrays.asList("xxx","yyy","zzz");//(不过这样的话这个list的size就固定了，不能再add了，要注意。)
        System.out.println(name1);
        List<String> name2 = new ArrayList<>(Arrays.asList("xxx","yyy","zzz"));
        System.out.println(name2);
        try{
            name1.add("ppp");
        }
        catch(UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException错误"+e);
        }
        catch (Exception e) {
            System.out.println("一般错误"+e);
        }
        finally {
            System.out.println(name1);
        }
    }
    private void arrest() {
        ArrayList al = new ArrayList();
        for(int i = 0; i < al.size(); i +=1){
            System.out.println(al.get(i));
        }

    }

    public static void main(String[] args) throws Exception {
        MyArrayList ml = new MyArrayList();
        ml.arrest();


    }
}
