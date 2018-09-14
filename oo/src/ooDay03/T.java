package ooDay03;

public class T extends Tetromino{
	
	//构造方法
	T(int row,int col){
		super();//调用父类的无参构造----默认的
		this.cells[0] = new Cell(row,col);
		this.cells[1] = new Cell(row,col+1);
		this.cells[2] = new Cell(row,col+2);
		this.cells[3] = new Cell(row+1,col+1);
	}
	
	
}
