package functest.set;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyEntrySet {
    private static void entrySet(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("01", "zhangsan");
        map.put("02", "lisi");
        map.put("03", "wangwu");
        // 通过entrySet()方法将map集合中的映射关系取出（这个关系就是Map.Entry类型）
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        //将关系集合entrySet进行迭代，存放到迭代器中
        Iterator<Map.Entry<String, String>> it2 = entrySet.iterator();
        while (it2.hasNext()) {
            //获取Map.Entry关系对象me
            Map.Entry<String, String> me = it2.next();
            //通过关系对象获取key
            String key2 = me.getKey();
            //通过关系对象获取value
            String value2 = me.getValue();
            System.out.println("key: " + key2 + "-->value: " + value2);
        }
    }

    public static void main(String[] args){
        entrySet();
    }
}
