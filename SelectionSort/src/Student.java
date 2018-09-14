import java.util.Comparator;

public class Student implements Comparator<Student> {
	public Student() {
		
	}
	@Override
	public int compare(Student o1,Student o2) {
		if(o1.getScore() > o2.getScore()){
			  return 1;
		}else if(o1.getScore() < o2.getScore()){
			 return -1;
		}else{
			return 0;
		}
	}
	private int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

}
