package review;

public class Test {
	public static void main(String[] args) {
		boolean flag;
		for(int i=1;i<100;i++){
			flag=true;
			for(int j=2;j<=Math.sqrt(i);j++){
				if(i%j==0){
					flag=false;
					break;
				}
			}
			if(flag){
				System.out.println(i);
			}
		}
	}
}
