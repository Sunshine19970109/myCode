package Practice;

public class T  extends Tetromino{
	T(){
		super();
	}
	T(int row, int col){
		super();
		this.cells[0] = new Cell(row, col);
		this.cells[1] = new Cell(row, col+1);
		this.cells[2] = new Cell(row, col+2);
		this.cells[3] = new Cell(row+1, col+1);
	}
}
