package ooDay03;

public class T extends Tetromino{
	
	//���췽��
	T(int row,int col){
		super();//���ø�����޲ι���----Ĭ�ϵ�
		this.cells[0] = new Cell(row,col);
		this.cells[1] = new Cell(row,col+1);
		this.cells[2] = new Cell(row,col+2);
		this.cells[3] = new Cell(row+1,col+1);
	}
	
	
}
