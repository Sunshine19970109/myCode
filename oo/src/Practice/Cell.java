package Practice;

public class Cell {
	int row;
	int col;
	Cell(){
		
	}
	Cell(int row,int col){
		this.row = row;
		this.col = col;
	}
	public String getCellInfo(){
		return "("+this.row+","+this.col+")";
	}
}
