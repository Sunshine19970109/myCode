package ooDay03;

public class Cell {
	int row;//行号
	int col;//列号
	
	Cell(){
		this(0,0);
	}
	
	Cell(int n){
		this(n,n);
	}
	Cell(int col,int row){
		this.row = row;
		this.col = col;
	}
	
	void drop(){//下落一格
		row++;
	}
	void moveLeft(int n){//左移n格
		col-=n;
	}
	String getCellInfo(){//获取行号和列号
		return "("+row+","+col+")";
	}
	void drop(int n){//下落n格
		row+=n;
	}
	void moveLeft(){//左移一格
		col--;
	}
}
