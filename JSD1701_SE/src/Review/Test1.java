package Review;

public class Test1 {
	public static void main(String[] args) {
		String imgName = "123.jpg";
//		String[] names = imgName.split("\\.");
//		System.out.println(names[1]);
		int index = imgName.lastIndexOf('.');
		String names = imgName.substring(index);
		long time = System.currentTimeMillis();
		imgName = time+names;
		System.out.println(imgName);
	}
}
















