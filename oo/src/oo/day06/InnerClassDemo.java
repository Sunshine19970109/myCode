package oo.day06;



//��Ա�ڲ�����ʾ
public class InnerClassDemo {

	public static void main(String[] args) {
		Mama m = new Mama();
//		Baby b = new Baby();//�������
	}

}
class Mama{
	private String name;
	Baby CreatBaby(){
		return new Baby();
	}
	class Baby{
		 void showMamaName() {
			// TODO Auto-generated method stub
			 System.out.println(name);
			 System.out.println(Mama.this.name);
//			 System.out.println(this.name);//�������
		}
	}
}















