package functest.map;

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
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");
        map.put("d", "ddd");
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println("map.get(key) is :"+map.get(key));
        }
        Hashtable tab=new Hashtable();
        tab.put("a", "aaa");
        tab.put("b", "bbb");
        tab.put("c", "ccc");
        tab.put("d", "ddd");
        Iterator iterator_1 = tab.keySet().iterator();
        while (iterator_1.hasNext()) {
            Object key = iterator_1.next();
            System.out.println("tab.get(key) is :"+tab.get(key));
        }

        TreeMap tmp=new TreeMap();
        tmp.put("a", "aaa");
        tmp.put("b", "bbb");
        tmp.put("c", "ccc");
        tmp.put("d", "ddd");
        Iterator iterator_2 = tmp.keySet().iterator();
        while (iterator_2.hasNext()) {
            Object key = iterator_2.next();
            System.out.println("tmp.get(key) is :"+tmp.get(key));
        }
        // map.put(ele1, map.getOrDefault(ele1, 0) + 1);
    }
}
