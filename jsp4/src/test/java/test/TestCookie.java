package test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;


public class TestCookie {
	public static void main(String[] args) {
		String s;
		try {
			s = URLEncoder.encode("���", "utf-8");
			System.err.println(s);
			Cookie c = new Cookie("stu", s);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
}
