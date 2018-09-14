package cn.it_cast_06;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameDemo {
public static void main(String[] args) {
	//创建窗体对象
	Frame f = new Frame("更改背景色");
	//设置窗体属性
	f.setBounds(400,200,400,300);
	f.setLayout(new FlowLayout());
	//创建四个按钮
	Button red = new Button("红色");
	Button green  = new Button("绿色");
	Button Blue = new Button("蓝色");
	Button Yellow = new Button("黄色");
	//设置窗体关闭事件
	f.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			super.windowClosing(e);
			System.exit(0);
		}
	});
	f.add(red);
	f.add(green);
	f.add(Blue);
//	red.addActionListener(new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			f.setBackground(Color.red);
//		}
//	});
//	red.addMouseListener(new MouseAdapter() {
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			// TODO Auto-generated method stub
//			super.mouseClicked(e);
//			f.setBackground(Color.red);
//		}
//	});
	//对按钮添加进入事件
	red.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseEntered(e);
			f.setBackground(Color.RED);
		}
	});
	red.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseMoved(e);
			f.setBackground(Color.black);
		}
	});
	green.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseEntered(e);
			f.setBackground(Color.GREEN);
		}
	});
	green.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseMoved(e);
			f.setBackground(Color.black);
		}
	});
	Blue.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseEntered(e);
			f.setBackground(Color.BLUE);
		}
	});
	Blue.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseMoved(e);
			f.setBackground(Color.black);
		}
	});
	//设置窗体可见
	f.setVisible(true);
}
}
