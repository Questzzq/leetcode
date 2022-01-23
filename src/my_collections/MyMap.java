package my_collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyMap {
    public static void main(String[] args) {
        double maxValue = Math.pow(2, 31) - 1;
        String s1 = "123";
        String s2 = "12";

        Map<Integer, Character> map = new HashMap<>();
        map.put(1, 'a');
        map.put(2, 'b');
        map.put(3, 'c');

        //方式一：entrySet遍历，在键和值都需要的情况下使用，最常用，效率比Iterator高
        for(Map.Entry<Integer, Character> entry: map.entrySet()) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
        //方式二：Iterator遍历
        Iterator<Map.Entry<Integer, Character>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Character> entry = iterator.next();
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
        //方式三：遍历map中的键
        for(Integer key: map.keySet()) {
            System.out.println("key = " + key);
        }
        //方式四：遍历map中的值
        for(Character value: map.values()) {
            System.out.println("value = " + value);
        }
        //方式五：java8 lambda
        //java8提供了Lambda表达式，语法简洁，可以拿到key和value
        //性能略低于entrySet
        map.forEach((k, v)->{
            System.out.println(k + "-->" + v);
        });
    }
}
