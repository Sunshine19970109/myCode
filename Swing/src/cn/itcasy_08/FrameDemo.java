package cn.itcasy_08;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//����:һ���˵�
public class FrameDemo {
public static void main(String[] args) {
	Frame f = new Frame("����ϼ");
	//f.setTitle("HelloWorld");
	f.setSize(400,300);//����
	f.setLocation(400,200);
	//����һ���������ô���ɼ�
	f.setVisible(true);
	//�����˵���
	MenuBar mb = new MenuBar();
	//�����˰�
	Menu m = new Menu("�ļ�");
	//�����˵���
	MenuItem mi = new MenuItem("�˳�ϵͳ");
	m.add(mi);
	mb.add(m);
	f.setMenuBar(mb);
	mi.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	});
	
	System.out.println("helloworld");
	f.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			super.windowClosing(e);
			System.exit(0);
			
		}
	});
}


}
