package ooDay03;

public class Tetromino {
	//成员变量
		Cell[] cells;
		Tetromino(){
			this.cells= new Cell[4];
		}
		//下落
		void drop(){
			for (int i = 0; i < cells.length; i++) {
				cells[i].col++;
				print();
			}
		}
		//左移
		void moveLeft(){
			for (int i = 0; i < cells.length; i++) {
				cells[i].row--;
				print();
			}
		}
		//右移
		void moveRight(){
			for (int i = 0; i < cells.length; i++) {
				cells[i].row++;
				print();
			}
		}
		//打印
		void print(){
			for (int i = 0; i < cells.length; i++) {
				String str = this.cells[i].getCellInfo();
				System.out.println(str);
			}
		}
}
