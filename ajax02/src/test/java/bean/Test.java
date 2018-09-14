package bean;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	/*
	 * 将java对象转换成json字符串
	 */
	public static void test1(){
		Stock s = new Stock();
		s.setCode("600877");
		s.setName("中国嘉陵");
		s.setPrice(8);
		//使用jackson提供的api来替换
		ObjectMapper om=
			new ObjectMapper();
		try {
			String jsonStr = 
				om.writeValueAsString(s);
			System.out.println(jsonStr);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 将多个对象组成的集合转换成json字符串
	 * @throws JsonProcessingException 
	 */
	public static void test2() throws JsonProcessingException{
		List<Stock> stocks = 
			new ArrayList<Stock>();
		for(int i=0;i<3;i++){
			Stock s = new Stock();
			s.setCode("600877");
			s.setName("中国嘉陵");
			s.setPrice(8);
			stocks.add(s);
		}
		ObjectMapper om = 
			new ObjectMapper();
		String jsonStr= 
			om.writeValueAsString(stocks);
		System.out.println(jsonStr);
	}
	
	public static void main(String[] args) {
		test1();
		try {
			test2();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
