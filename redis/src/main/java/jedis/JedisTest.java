package jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest {
	@Test
	//获得一个jedis对象操作数据
	public void testNew(){
		//创建对象
		Jedis jedis = new Jedis("192.168.126.128", 6379);
		//取数据
		String res = jedis.get("username");
		System.out.println(res);
		//存数据
		jedis.set("addr", "天津");
		System.out.println("addr : "+jedis.get("addr"));
	}
	
	//通过Jedis的pool获得jedis连接对象
	@Test
	public void testJedisPool(){
		//创建池子的配置对象
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(30);//最大闲置时个数
		config.setMinIdle(10);//最小闲置个数
		config.setMaxTotal(50);//最大连接数
		JedisPool pool = new JedisPool(config, "192.168.126.168", 6379);
		
		//从连接池获取访问资源
		Jedis jedis = pool.getResource();
		
		//操作数据库(这种最常用，这里可以什么东西都存)
		//可以将对象转化为一个字符串
		jedis.set("user", "");
		System.out.println(jedis.get("user"));
		
		//关闭资源
		jedis.close();
		pool.close();//真正用的时候不关闭这个
	}
}
