package ooDay03;

public class CellTest {
public static void main(String[] args) {
	Cell c = new Cell(3,2);
	printWall(c);
	System.out.println("---------------------------");
	c.drop();
	c.moveLeft();
	printWall(c);
}
public static void printWall(Cell c){
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 5; j++) {
			if(i == c.col&&j==c.row){
				System.out.print("#"+"  ");
			}else{
			System.out.print("*"+"  ");
			}
		}
		System.out.println();
	}
}

}
