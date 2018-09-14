package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;


/**
 * 测试消息摘要
 * @author soft01
 *
 */
public class TestMd5 {
	@Test
	public void testString() {
		String s1 = "123456";
		String s2 = "123456";
		String s3 = "";
		String Ms1 = DigestUtils.md5Hex(s1);
		String Ms2 = DigestUtils.md5Hex(s2);
		String Ms3 = DigestUtils.md5Hex(s3);
		System.out.println("Ms1 = "+Ms1);
		System.out.println("Ms2 = "+Ms2);
		System.out.println("Ms3 = "+Ms3);
	}
	@Test
	public void testFile() throws FileNotFoundException, IOException {
		String s1 = DigestUtils.md5Hex(new FileInputStream("数据库.txt"));
		String s2 = DigestUtils.md5Hex(new FileInputStream("数据库2.txt"));
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1.equals(s2));
	}
	@Test
	public void testSalt() {
		String s1 = "123456";
		String s2 = "大家好，我非常喜欢程序员这个工作";
		System.out.println(DigestUtils.md2Hex(s1+s2));
		System.out.println(DigestUtils.md2Hex(s1));
	}
}
