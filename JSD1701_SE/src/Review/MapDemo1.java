package Review;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.HashMap;
 * ���ұ�
 * ��key-value�Ե���ʽ����Ԫ��
 * ����ʵ����:java.util.HashMap(��ɢ���㷨ʵ�ֵ�Map)
 * @author dell
 *
 */
public class MapDemo1 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		/*
		 * V put (K k,V v)
		 * ��������һ���ֵ�Դ��뵽Map��
		 */
		map.put("����", 98);
		map.put("��ѧ", 96);
		map.put("Ӣ��", 99);
		map.put("����", 95);
		Integer i = map.put("����", 70);
		System.out.println(i);
		System.out.println(map);
		Integer r1 = map.get("����");
		System.out.println(r1);
		Integer r2 = map.remove("��ѧ");
		System.out.println(r2);
		System.out.println(map);
	}
}


























