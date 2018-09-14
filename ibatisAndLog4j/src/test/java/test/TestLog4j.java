package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class TestLog4j {
/*
 * //日志的名字是传入的任何字符串，通常为类名或包名
        Logger log = Logger.getLogger(Log4jDemo.class);
         PropertyConfigurator.configure("myLog4j.properties");
        debug 调式
		info 信息
		warn 警告
		error 错误
		fatal 致命 
 */
		public static void main(String[] args) throws FileNotFoundException, IOException {
			Logger log = Logger.getLogger(TestLog4j.class);
			Properties properties = new Properties();
			properties.load(new FileInputStream("log4j.properties"));
			PropertyConfigurator.configure(properties);
			log.debug("debug");
			log.info("我是信息");
			log.warn("warn");
			log.error("error");
			log.fatal("fatal");
		}
}
