package activemqtest.test;

public class Test {
	public static void main(String[] args) {
		ActiveMQTest test = new ActiveMQTest();
		try {
			test.testMQProducerQueue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
