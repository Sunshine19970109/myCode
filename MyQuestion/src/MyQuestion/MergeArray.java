package MyQuestion;

import java.util.Arrays;

/*��Java�У���ΰ�����String[]�ϲ�Ϊһ����
 * ����һ:
 * String[] both = (String[]) ArrayUtils.addAll(first, second);//һ�и㶨,��δ�ҵ�ArrayUtils
 * Ϊ�˷��㣬�ҽ�����һ�����߷���concat�����԰���������ϲ���һ��
 * static <T> T[] concat(T[] first, T[] second) {}
 * ������:
 * System.arraycopy()
 * static String[] concat(String[] a, String[] b) {
   String[] c= new String[a.length+b.length];
   System.arraycopy(a, 0, c, 0, a.length);
   System.arraycopy(b, 0, c, a.length, b.length);
   return c;
}
 * */
public class MergeArray {
	public static void main(String[] args) {
		String[] a = new String[]{"sddv","vegdfv"}; 
		String[] b = new String[]{"��ߺ�","˧"}; 
		String[] s = MergeArray.concat(a, b);
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]);
		System.out.println("----------------");

		String[] result = MergeArray.concat(a, b);
		for (int j = 0; j < result.length; j++) {
			System.out.println(result[j]);
		}
		}
		//int[]�����ƴ��ԭ����ô��
		System.out.println("----------------");
		int a1[] = new int[4];
		a1[0] = 1;
		a1[1] = 2;
		int a2[] = { 3, 4 };
		System.arraycopy(a2, 0, a1, 2, 2);
		System.out.println(Arrays.toString(a1));
		
	}
	/*public static <T> T[] concat(T[] first, T[] second) {  }
	 * 
	 * */
	static <T>T[] concat(T[] first, T[] second) {
		 T[] result = Arrays.copyOf
				 (first, first.length + first.length);  
		   System.arraycopy
		   (first, 0, result, 0, first.length);
		   //������a��0λ�ÿ�ʼ������c��0��a.length�ĳ��ȷ�Χ��
		   System.arraycopy
		   (second, 0, result,first.length,second.length);
		   return result;
	}
	static String[] concat(String[] a, String[] b) {
		   String[] c= new String[a.length+b.length];
		   System.arraycopy(a, 0, c, 0, a.length);
		   //������a��0λ�ÿ�ʼ������c��0��a.length�ĳ��ȷ�Χ��
		   System.arraycopy(b, 0, c, a.length, b.length);
		   return c;
		}
	private static <T> T[] concat1(T[] a, T[] b) {
	    final int alen = a.length;
	    final int blen = b.length;
	    if (alen == 0) {
	        return b;
	    }
	    if (blen == 0) {
	        return a;
	    }//ӳ���е�����newInstance�����õ�һ��T������(����Ϊa.getClass().getComponentType(),
	    //����Ϊa.length+b.length)
	    final T[] result = (T[]) java.lang.reflect.Array.
	            newInstance(a.getClass().getComponentType(), alen + blen);
	    System.arraycopy(a, 0, result, 0, alen);
	    System.arraycopy(b, 0, result, alen, blen);
	    return result;
	}

}
