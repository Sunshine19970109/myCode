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
		//���������ļ�
		//ResourceBundle�������ʹ�����������Թ��ʻ��뱾��
		//����Properties
		Properties properties = new Properties();
		InputStream stream = JedisPoolUtils.class.getClassLoader().getResourceAsStream("redis.properties");
		try {
			properties.load(stream);
			Integer maxIdle = Integer.parseInt(properties.get("maxIdle").toString());
			Integer minIdle = Integer.parseInt(properties.get("minIdle").toString());
			Integer maxTotal = Integer.parseInt(properties.get("maxTotal").toString());
			Integer port = Integer.parseInt(properties.get("port").toString());
			String url = properties.get("url").toString();
			//��ȡ���Ӷ���
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxIdle(maxIdle);//�������ʱ����
			config.setMinIdle(minIdle);//��С���ø���
			config.setMaxTotal(maxTotal);//���������
			pool = new JedisPool(config,url, port);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	//���jedis��Դ�ķ���
	public static Jedis getJedis(){
		return pool.getResource();
	}
	
}
