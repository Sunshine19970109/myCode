package Practice;

public class TJtest {
public static void main(String[] args) {
	Tetromino t = new T(2,2);
	for(int i = 0;i<t.cells.length;i++){
		String str =t.cells[i].getCellInfo();
		System.out.println(str);
	}
	
	PrintWall(t);
	
}
public static void PrintWall(Tetromino t){
	for (int i = 0; i < 20; i++) {
		
		for (int j = 0; j < 10; j++) {
			boolean flag = true;
			for(int k = 0;k<t.cells.length;k++){
				
				if(t.cells[k].row==i&&t.cells[k].col==j){
					flag = false;
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
