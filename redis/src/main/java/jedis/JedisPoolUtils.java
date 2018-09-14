package jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtils {
	private static JedisPool pool;
	static{
		//加载配置文件
		//ResourceBundle这里如果使用这个对象可以国际化与本地
		//代替Properties
		Properties properties = new Properties();
		InputStream stream = JedisPoolUtils.class.getClassLoader().getResourceAsStream("redis.properties");
		try {
			properties.load(stream);
			Integer maxIdle = Integer.parseInt(properties.get("maxIdle").toString());
			Integer minIdle = Integer.parseInt(properties.get("minIdle").toString());
			Integer maxTotal = Integer.parseInt(properties.get("maxTotal").toString());
			Integer port = Integer.parseInt(properties.get("port").toString());
			String url = properties.get("url").toString();
			//获取池子对象
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxIdle(maxIdle);//最大闲置时个数
			config.setMinIdle(minIdle);//最小闲置个数
			config.setMaxTotal(maxTotal);//最大连接数
			pool = new JedisPool(config,url, port);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	//获得jedis资源的方法
	public static Jedis getJedis(){
		return pool.getResource();
	}
	
}
