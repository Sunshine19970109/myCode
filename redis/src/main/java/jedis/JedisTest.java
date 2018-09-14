package jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest {
	@Test
	//���һ��jedis�����������
	public void testNew(){
		//��������
		Jedis jedis = new Jedis("192.168.126.128", 6379);
		//ȡ����
		String res = jedis.get("username");
		System.out.println(res);
		//������
		jedis.set("addr", "���");
		System.out.println("addr : "+jedis.get("addr"));
	}
	
	//ͨ��Jedis��pool���jedis���Ӷ���
	@Test
	public void testJedisPool(){
		//�������ӵ����ö���
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(30);//�������ʱ����
		config.setMinIdle(10);//��С���ø���
		config.setMaxTotal(50);//���������
		JedisPool pool = new JedisPool(config, "192.168.126.168", 6379);
		
		//�����ӳػ�ȡ������Դ
		Jedis jedis = pool.getResource();
		
		//�������ݿ�(������ã��������ʲô��������)
		//���Խ�����ת��Ϊһ���ַ���
		jedis.set("user", "");
		System.out.println(jedis.get("user"));
		
		//�ر���Դ
		jedis.close();
		pool.close();//�����õ�ʱ�򲻹ر����
	}
}
