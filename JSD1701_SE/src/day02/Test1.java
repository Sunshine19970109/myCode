package day02;

public class Test1 {
public static void main(String[] args) {
	String imgName = "123.jpg";
//	String[] names = imgName.split("\\.");
	int index = imgName.lastIndexOf('.');
	String names = imgName.substring(index);
	long time = System.currentTimeMillis();
	imgName = time+names;
	System.out.println(imgName);
}
}

















