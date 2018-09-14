package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Point;

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	@RequestMapping("/ary.do")
	@ResponseBody
	//ResponseBody���Զ������ؽ����JavaBeanת��
	//ΪJSON�ַ������͵�������ͻ��ˣ��ײ�����
	//Jackson API
	public Object test() {
		String[] ary = {"����","�ܶ�","�ܴ�"};
		return ary;
	}
	
	@RequestMapping("p.do")
	@ResponseBody
	/*
	 * ��JavaBean��Ϊ����ֵ��ResponseBodyע�⽫Bean
	 * ת��ΪJSON�ַ������͵��������
	 */
	public Object test1(){
		Point p = new Point();
		p.setX(2.0);
		p.setY(3.0);
		p.setName("P1");
		return p;
	}
	@RequestMapping("/list.do")
	//���ע��ǳ�ʡ�£�ֻҪ�����ˣ�������spring������
	@ResponseBody
	public Object list(){
		List<Point> list = new ArrayList<Point>();
		list.add(new Point("p1",1.2,2.1));
		list.add(new Point("p2",1.2,2.1));
		list.add(new Point("p3",1.2,2.1));
		return list;
	}
	@RequestMapping("/map.do")
	@ResponseBody
	public Object map(){
		/*
		 * LinkedHashMap����˳���Map
		 * HashMap��û��˳���
		 */
		Map<String,Object> map = 
				new LinkedHashMap<String, Object>();
		map.put("age", 20);
		map.put("name", "Andy");
		map.put("price", 123.6);
		return map;
	}
	
	@RequestMapping("/list2.do")
	@ResponseBody
	public Object list2(){
		List<String> list = 
				new ArrayList<String>();
		list.add("����");
		list.add("�ܴ�");
		list.add("�ܶ�");
		return list;
	}
	//List<Map>
	@RequestMapping("/map2.do")
	@ResponseBody
	public Object map2(){
		List<Map<String,Object>> list = 
			new ArrayList<Map<String,Object>>();
		Map<String,Object> map =
			new HashMap<String, Object>();
		map.put("age", 5);
		map.put("name", "Tom");
		map.put("price", 4.5);
		Map<String,Object> map1 =
				new HashMap<String, Object>();
			map1.put("age", 6);
			map1.put("name", "Anndy");
			map1.put("price", 4.5);
		Map<String,Object> map2 =
				new HashMap<String, Object>();
			map2.put("age", 7);
			map2.put("name", "Jim");
			map2.put("price", 4.5);
		list.add(map);
		list.add(map1);
		list.add(map2);
		return list;
	}
}

















