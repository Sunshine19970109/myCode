
public class MathTest {
	 public static void main(String[] args) {
	        MathTest mathTest = new MathTest();
	        System.out.println(mathTest.max(1, 2));
	        System.out.println(mathTest.max(2.0, 3.0));
	    }
	    private <T extends Comparable> T max(T t1, T t2) {
	        return t1.compareTo(t2) > 0 ? t1 : t2;
	    }	
}
