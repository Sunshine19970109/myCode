package day09;
/**
 * ʹ�������������throw,throws������
 * @author dell
 *
 */
public class Person {
	private int age;

	public int getAge() {
		return age;
	}
	/*
	 * 1.�׳����������䲻�Ϸ��쳣
	 * throw�ؼ��������׳��쳣:
	 * ͨ������������׳��쳣: 
	 * 1:�������﷨Ҫ�󣬵��ǲ�����ʵ��ҵ���߼�ʱ������
	 * ����һ���쳣�׳�ȥ
	 * 2:�ڵ�ǰ�����г�����һ��ʵ�ʵ��쳣�����ǲ�Ӧ����
	 * ��ǰ�����д������쳣ʱ�����Խ����׳�
	 */
	/*
	 * 1.ֻ��runtimeException ����������Բ���
	 * �ڷ������ĺ���throws �׳��쳣���������쳣����
	 * �����׳���
	 */
	public void setAge(int age) throws IllegalAgeException {
		if (age<0||age>100) {
			throw new IllegalAgeException("���䲻�Ϸ�");
		}
		this.age = age;
	}
	
}





















