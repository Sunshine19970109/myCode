package day09;
/**
 * java�쳣��������е�try--catch
 * 
 * @author dell
 *
 */
public class ExceptionDemo {
	/*
	 * 1.try--catch�����쳣
	 * 2.��ô����Ĵ���,catch����д���
	 * catch����д�������Բ�ͬ�쳣�Ͳ�ͬ����ֶ�
	 * ʱ���Էֱ𲶻���Щ�쳣������
	 * 
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("����ʼ��");
		try{
			String s = "abc";
			System.out.println(s.length());
			char ch = s.charAt(1);
			System.out.println(Integer.valueOf(s));
			/*
			 * try�г���Ĵ������µ����д��붼��������
			 * �������
			 */
			System.out.println("!!!!!!!!!");
		}catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("���ֿ�ָ���쳣");
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("�����ַ���Խ��");
		}catch (NumberFormatException e) {
			System.out.println("���ָ�ʽ�쳣");
		/*
		 * Ӧ������һ����ϰ�ߣ������һ��catch�в�׽
		 * Exception,����������Ϊһ��δ������쳣
		 * �����жϡ�
		 * ���쳣֮����ڸ�����̳й�ϵʱ��һ�������쳣
		 * �������в��񣬸����쳣���º󲶻�
		 */
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("������");
		}
		System.out.println("���������");
	}
}




















