package ooDay03;

public class RefArrayDemo {
public static void main(String[] args) {
	Cell[] cells = new Cell[4];
	cells[0] = new Cell(2,5);
	cells[1] = new Cell(2,5);
	cells[2] = new Cell(2,6);
	cells[3] = new Cell(2,7);

	int[][] arr = new int[3][];
	arr[0] = new int[2];
	arr[1] = new int[3];
	arr[2] = new int[2];
	arr[1][0] = 100;

	Cell[] cs = new Cell[]{
		new Cell(2,5),
		new Cell(2,6),
		new Cell(2,7),
		new Cell(3,6)
	};
	int[][] as = new int[3][4];//3ÐÐ4ÁÐ

}
}
