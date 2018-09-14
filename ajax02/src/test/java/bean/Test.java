package bean;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	/*
	 * ��java����ת����json�ַ���
	 */
	public static void test1(){
		Stock s = new Stock();
		s.setCode("600877");
		s.setName("�й�����");
		s.setPrice(8);
		//ʹ��jackson�ṩ��api���滻
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
	 * �����������ɵļ���ת����json�ַ���
	 * @throws JsonProcessingException 
	 */
	public static void test2() throws JsonProcessingException{
		List<Stock> stocks = 
			new ArrayList<Stock>();
		for(int i=0;i<3;i++){
			Stock s = new Stock();
			s.setCode("600877");
			s.setName("�й�����");
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
