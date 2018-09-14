package ooDay04;

public class Cell {
	int row;
	int col;
	Cell(int row,int col){
		this.row = row;
		this.col = col;
	}
	String getCellInfo(){
		return "("+this.row+","+this.col+")";
	}
}
