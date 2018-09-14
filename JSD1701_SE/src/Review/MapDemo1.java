package Review;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.HashMap;
 * 查找表
 * 以key-value对的形式储存元素
 * 常用实现类:java.util.HashMap(由散列算法实现的Map)
 * @author dell
 *
 */
public class MapDemo1 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		/*
		 * V put (K k,V v)
		 * 将给定的一组键值对存入到Map中
		 */
		map.put("语文", 98);
		map.put("数学", 96);
		map.put("英语", 99);
		map.put("物理", 95);
		Integer i = map.put("语文", 70);
		System.out.println(i);
		System.out.println(map);
		Integer r1 = map.get("语文");
		System.out.println(r1);
		Integer r2 = map.remove("数学");
		System.out.println(r2);
		System.out.println(map);
	}
}


























