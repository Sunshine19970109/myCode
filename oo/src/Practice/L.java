package Practice;

public class L extends Tetromino{
	L(){
		
	}
	L(int row,int col){
		super();
		cells[0] = new Cell(row, col);
		cells[1] = new Cell(row+1,col);
		cells[2] = new Cell(row+2,col);
		cells[3] = new Cell(row,col+1);
	}
}
