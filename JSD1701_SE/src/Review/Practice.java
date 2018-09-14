package Review;

public class Practice {
	public static void main(String[] args) {
		String s = "someapp/manager/emplist.action";
		int index = s.lastIndexOf('/');
		String s1 = s.substring(index+1, s.length());
		System.out.println(s1);
		System.out.println("---------");
		String s2 = "able was i ere i saw elba";
		huiwen(s2);
	}

	public static void huiwen(String s) {
		boolean flag = false;
		StringBuilder s1 = new StringBuilder(s);
		for (int i = 0; i < s1.length()/2; i++) {
			if (s1.charAt(i)!=s1.charAt(s1.length()-i-1)) {
				System.out.println("不是回文");
				flag = false;
				break;
			}else{
				flag = true;
			}
		}
		if (flag==true) {
			System.out.println("是回文");
		}
		
		
	}
}
















