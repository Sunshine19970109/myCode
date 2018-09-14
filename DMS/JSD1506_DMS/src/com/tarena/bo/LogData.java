package com.tarena.bo;
/**
 * �������ڱ�ʾwtmpx�ļ��ϵ�һ����־
 * �������ǵ�ҵ���߼�ֻ��Ҫһ����־�е�������Ϣ
 * ����������ṩ������Լ��ɡ�
 * @author Administrator
 *
 */
public class LogData {
	/*
	 * ��������
	 * 
	 * ÿ��ʵ����Ӧ�����У�����ֵ��һ���ģ���Ӧ��
	 * ����Ϊ���ԣ���ÿ��ʵ����һ���ľ�Ӧ������Ϊ
	 * ������
	 */
	/**
	 * ��־����-������־
	 */
	public static final short TYPE_LOGIN=7;
	
	/**
	 * ��־����-�ǳ���־
	 */
	public static final short TYPE_LOGOUT=8;
	
	/**
	 * ��־��wtmpx�ļ��еĳ���(�ֽ���)
	 */
	public static final int LOG_LENGTH=372;
	
	/**
	 * user��һ����־�е���ʼλ��
	 */
	public static final int USER_OFFSET=0;
	
	/**
	 * user��һ����־��ռ�õ��ֽ���
	 */
	public static final int USER_LENGTH=32;
	
	/**
	 * pid��һ����־�е���ʼλ��
	 */
	public static final int PID_OFFSET=68;
	
	/**
	 * type��һ����־�е���ʼλ��
	 */
	public static final int TYPE_OFFSET=72;
	
	/**
	 * time��һ����־�е���ʼλ��
	 */
	public static final int TIME_OFFSET=80;
	
	/**
	 * host��һ����־�е���ʼλ��
	 */
	public static final int HOST_OFFSET=114;
	
	/**
	 * host��һ����־��ռ�õ��ֽ���
	 */
	public static final int HOST_LENGTH=258;
	
	//�û���
	private String user;
	//����ID
	private int pid;
	//��־����
	private short type;
	//��־����ʱ��
	private int time;
	//�û���ַ
	private String host;
	
	public LogData(){
		
	}

	public LogData(String user, int pid, short type, int time, String host) {
		super();
		this.user = user;
		this.pid = pid;
		this.type = type;
		this.time = time;
		this.host = host;
	}
	/**
	 * ���������ַ������н�������LogData��ʽ����
	 * ���ַ����ĸ�ʽ�������ɵ�ǰ���toString����
	 * �����ĸ�ʽ��
	 * user,pid,type,time,host
	 * @param str
	 */
	public LogData(String str){
		String[] data = str.split(",");
		user = data[0];
		pid = Integer.parseInt(data[1]);
		type = Short.parseShort(data[2]);
		time = Integer.parseInt(data[3]);
		host = data[4];
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	
	public String toString(){
		return user+","+pid+","+
	           type+","+time+","+
			   host;
	}
}




