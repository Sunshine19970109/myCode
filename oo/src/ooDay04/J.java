package ooDay04;

public class J extends Tetromino{
	J(){
		
	}
	J(int row,int col){
		super();
		cells[0] = new Cell(row, col);
		cells[1] = new Cell(row+1, col);
		cells[2] = new Cell(row+2, col);
		cells[3] = new Cell(row+2, col-1);
	}
	
	@Override
	void print() {
		// TODO Auto-generated method stub
		System.out.println("I am a J");
		super.print();
	}
}
