package cn.itcasy_08;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//需求:一级菜单
public class FrameDemo {
public static void main(String[] args) {
	Frame f = new Frame("林青霞");
	//f.setTitle("HelloWorld");
	f.setSize(400,300);//像素
	f.setLocation(400,200);
	//调用一个方法，让窗体可见
	f.setVisible(true);
	//创建菜单栏
	MenuBar mb = new MenuBar();
	//创建菜案
	Menu m = new Menu("文件");
	//创建菜单项
	MenuItem mi = new MenuItem("退出系统");
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
