package com.sunshine;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameDemo4 {
public static void main(String[] args) {
	//创建对象
	//Frame f = new Frame();
	Frame f = new Frame("林青霞");
	//f.setTitle("HelloWorld");
	f.setSize(400,300);//像素
	f.setLocation(400,200);
	//调用一个方法，让窗体可见
	f.setVisible(true);
	
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
