package ooDay03;

public class J extends Tetromino{
	
	//构造方法,col是列，row是行
	J(int row,int col){
		
		this.cells[0] = new Cell(col, row);
		this.cells[1] = new Cell(col, row+1);
		this.cells[2] = new Cell(col, row+2);
		this.cells[3] = new Cell(col-1, row+2);
	}
	
}
