package BiaoDaShi;

public  class isOdd{
	public static void main(String[] args) {
		isOdd a = new isOdd();
		System.out.println(a.isOdd(1));
		System.out.println(a.isOdd(5));
	}
	public static boolean isOdd(int i){
		return i%2==1;
	}
	public static boolean isOdd(double j){
		return j%2 !=0;
	}
}
