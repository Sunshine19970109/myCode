package ooDay03;

public class TTest {
public static void main(String[] args) {
	Tetromino t = new T(1,2);//向上造型
	printWall(t);//先造型后转值
	J o2 = new J(2, 2);
	printWall(o2);//传值得同时造型
	}

public static void printWall(Tetromino t) {
	// TODO Auto-generated method stub
	for (int i = 0; i < 20; i++) {
		for (int j = 0; j <10; j++) {
			boolean flag = true;
			for (int j2 = 0; j2 < t.cells.length; j2++) {
				
				if(i==t.cells[j2].row&&j==t.cells[j2].col){
					flag=false;
					break;
				}
			}
			if(flag){
				System.out.print("- ");
			}else{
				System.out.print("* ");
			}
		
			
		}
		System.out.println();
	}
}	
	
}
