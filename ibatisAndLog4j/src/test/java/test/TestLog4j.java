package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class TestLog4j {
/*
 * //��־�������Ǵ�����κ��ַ�����ͨ��Ϊ���������
        Logger log = Logger.getLogger(Log4jDemo.class);
         PropertyConfigurator.configure("myLog4j.properties");
        debug ��ʽ
		info ��Ϣ
		warn ����
		error ����
		fatal ���� 
 */
		public static void main(String[] args) throws FileNotFoundException, IOException {
			Logger log = Logger.getLogger(TestLog4j.class);
			Properties properties = new Properties();
			properties.load(new FileInputStream("log4j.properties"));
			PropertyConfigurator.configure(properties);
			log.debug("debug");
			log.info("������Ϣ");
			log.warn("warn");
			log.error("error");
			log.fatal("fatal");
		}
}
