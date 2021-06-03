package functest.map;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.UncheckedExecutionException;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * void                 clear()
 * Object               clone()
 * boolean              containsKey(Object key)
 * boolean              containsValue(Object value)
 * Set<Entry<K, V>>     entrySet()
 * V                    get(Object key)
 * boolean              isEmpty()
 * Set<K>               keySet()
 * V                    put(K key, V value)
 * void                 putAll(Map<? extends K, ? extends V> map)
 * V                    remove(Object key)
 * int                  size()
 * Collection<V>        values()
 */
@Slf4j
public class HashmapTest {
    private final Integer hmCap = 100;
    private final Float hmLoadFactor = 0.85F;

    public void setHashMap(){
        HashMap map1 = new HashMap(hmCap, hmLoadFactor);
        HashMap map2 = new HashMap(hmCap);
    }
    public void setHashMap2(){
        HashMap map1 = new HashMap(hmCap, hmLoadFactor);
        HashMap map2 = new HashMap(hmCap);
    }
    public static void main(String[] args) {
        try{
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("a", "aaa");
        map.put("a2", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");
        map.put("d", "ddd");
        Collection<String> valList= map.values();
        valList.forEach(k -> {
            log.info("k："+ k);
        });
        Set set = map.entrySet();
        Iterator its = set.iterator();
        while (its.hasNext()){
            Map.Entry<String, String> entry = (Map.Entry<String, String>)its.next();
            log.info(entry.getKey());
            log.info(entry.getValue());
        }


        // foreach
        map.forEach((key, value) -> {
            System.out.println(key + "：" + value);
        });

        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            System.out.println("map.get(key) is :"+map.get(key));
        }
        log.info(JSON.toJSONString(map.entrySet().toArray()));
        Hashtable<String, String> tab=new Hashtable<String, String>();
        tab.put("a", "aaa");
        tab.put("b", "bbb");
        tab.put("c", "ccc");
        tab.put("d", "ddd");
        Iterator iterator_1 = tab.keySet().iterator();
        while (iterator_1.hasNext()) {
            String key = (String) iterator_1.next();
            System.out.println("tab.get(key) is :"+tab.get(key));
        }

        TreeMap<String, String> tmp=new TreeMap<String, String>();
        tmp.put("a", "aaa");
        tmp.put("b", "bbb");
        tmp.put("c", "ccc");
        tmp.put("d", "ddd");
        Iterator iterator_2 = tmp.keySet().iterator();
        while (iterator_2.hasNext()) {
            String key = (String) iterator_2.next();
            System.out.println("tmp.get(key) is :"+tmp.get(key));
        }
        // map.put(ele1, map.getOrDefault(ele1, 0) + 1);
    }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * compute() 方法对 hashMap 中指定 key 的值进行重新计算。
     */
    public static void computeTest(){
        //创建一个 HashMap
        HashMap<String, Integer> prices = new HashMap<>();
        // 往HashMap中添加映射项
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);
        // 重新计算鞋子打了10%折扣后的值
        int newPrice = prices.compute("Shoes", (key, value) -> value - value * 10/100);
        System.out.println("Discounted Price of Shoes: " + newPrice);

        // 输出更新后的HashMap
        System.out.println("Updated HashMap: " + prices);
    }



}
