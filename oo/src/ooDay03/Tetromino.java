package ooDay03;

public class Tetromino {
	//��Ա����
		Cell[] cells;
		Tetromino(){
			this.cells= new Cell[4];
		}
		//����
		void drop(){
			for (int i = 0; i < cells.length; i++) {
				cells[i].col++;
				print();
			}
		}
		//����
		void moveLeft(){
			for (int i = 0; i < cells.length; i++) {
				cells[i].row--;
				print();
			}
		}
		//����
		void moveRight(){
			for (int i = 0; i < cells.length; i++) {
				cells[i].row++;
				print();
			}
		}
		//��ӡ
		void print(){
			for (int i = 0; i < cells.length; i++) {
				String str = this.cells[i].getCellInfo();
				System.out.println(str);
			}
		}
}
