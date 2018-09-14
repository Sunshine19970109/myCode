package day01;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Properties;

import org.junit.Test;

import util.DBTool;
/**
 * Junit
 * 1.����һ�����еĶ���������ܵ���ִ��
 * 2.�����ڷ���֮ǰ����@Test������������ִ��
 * 3.���������ǹ��еģ��޷���ֵ�ģ��޲ε�
 * 4.����ʽ��WEB��Ŀ�У�������Ҫ��������������
 * 	 ִ�У�Eclipse�ڿ�������ʱ�ᱻ�������Դ��룬
 *   ����Junit�İ�����Ҳ�ᱻ������������ʹ��maven
 *   �����������İ���
 * @author TeduJAVA
 *
 */
/*
 * maven: ����ȥdoc.tedu.cn�ĵ�������ȥ���ĵ�
 * ����ʧ����ô��?
 * 1 ��pom.xml�еĴ���(<dependency>)ɾ��
 * 2 ������ʧ�ܵĻ����ļ�ɾ��(/.m2/repository��)
 * ��Eclipse���
 */
public class TestDay01 {
	/*
	 *ֻҪ�ڲ��Է�������д��@Test�Ϳ��Ե���ִ��
	 *���Դ�����µķ���Junit
	 */
	/**
	 * ��δ�������
	 * �����ļ�key=values��׼��ʽ
	 */
	@Test
	public void test1(){
		
		//ע������
		try {
			/*
			 * �����࿽������
			 */
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//��������
		Connection conn = null;
		try {
			/*
			 * ����IP:192.168.1.182
			 * ����
			 * 1 jdbc:oracle:thin:@����IP:�˿�:SID
			 * 2 �û���
			 * 3 ����
			 */
			 conn = 
			DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe",
			"system","tedustudent");
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * ��ζ�ȡproperties�ļ�
	 * 1 ʹ��java.util.Properties��
	 * 2 �������Ͼ���Map
	 * 3 ��ר��������ȡproperties�ļ�
	 */
	@Test
	public void test2(){
		Properties p = new Properties();
		try {
			//��classes��ȥ��ȡ�����ļ�
			/*
			 * ������һ�㲻�������Ϊ�ж��db.properties
			 * �����������׳���
			 */
			p.load(TestDay01.class.getClassLoader()
					.getResourceAsStream("db.properties"));
			//��ȡֵ
			String driver = p.getProperty("driver");
			System.out.println(driver);
			/*
			 * ��������:
			 * ���Ȳ�����
			 * ѧ�����
			 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 1 ����DBTool.getConnection()�����ܲ�����
	 * 2 ִ��insert���
	 * INSERT INTO emps 
	 * VALUES(emps_seq.NEXTVAL,'��ɮ','����',0,SYSDATE,
	 * 8000,2000,3)
	 * 3 ÿ��ִ��֮��Ӧ��ִ��һ��commit,��Ȼjavaʶ��
	 * ����
	 * 4 д��SQL��Ҫд�ֺŽ���
	 */
	
	@Test
	public void test3(){
		Connection conn = null;
		try {
			//��������
			conn = DBTool.getConnection();
			System.out.println(conn);
			//����Statement--���԰�����ִ��SQL
			Statement smt = conn.createStatement();
			//SQL
			String sql = 
					"DELETE  FROM emps"+
					" WHERE emps.ename='��ɮ'";
			/*
			 *�������ӡ��޸ġ�ɾ���˼���
			 */
			int rows = smt.executeUpdate(sql);
			System.out.println(rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBTool.close(conn);
		}
	}
	
	/**
	 * ���ִ�в�ѯ���?
	 */
	@Test
	public void test4(){
		/*
		 * 1 ��������
		 * 2 ����statement����
		 * 3 дsql���
		 * 4 �ر�����
		 * 5 ctrl + shift +x/y ���Сд
		 */
		Connection conn = null;
		try {
			conn = DBTool.getConnection();
			Statement stm = conn.createStatement();
			String sql = "SELECT * FROM emps"
					+" WHERE deptno = 1 ORDER BY empno";
			//���ص�ResultSet�ǽ����
			//�ý���Ƕ��ж��е�
			/*
			 * �ö�����õ�����ģʽ��ƶ���
			 * ������ͨ��ʹ��while����
			 */
			ResultSet rs = stm.executeQuery(sql);
			//ÿ��next()�Ϳ��Զ�ȡ����һ������
			//ָ����һ��
			while(rs.next()){
				//��ȡ���е�ÿһ�е�ֵ
				/*
				 * rs.get����(�ֶε����)
				 * rs.get����(�ֶε�����)
				 * ����ʹ���ֶ���--��Ϊ���ʱ�䳤�˿�������ֶ�
				 */
				System.out.println(rs.getInt("empno"));
				System.out.println(rs.getString("ename"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBTool.close(conn);
		}
		
	}
	/**
	 * ����Update���
	 */
	@Test
	public void test5(){
		/*
		 * 1 ��������
		 * 2 ����Statement����
		 * 3 ִ��SQL���
		 * 4 ��ȡ���õ���������ResultSet�����
		 * 4 �ر�����
		 */
		Connection conn = null;
		try {
			conn = DBTool.getConnection();
			Statement stm = conn.createStatement();
			String sql = "UPDATE emps "
						+" SET ename='���' "
						+" WHERE empno = 10 ";
			int rows = stm.executeUpdate(sql);
			System.out.println(rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
}




























