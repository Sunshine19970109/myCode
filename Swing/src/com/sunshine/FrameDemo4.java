package com.sunshine;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameDemo4 {
public static void main(String[] args) {
	//��������
	//Frame f = new Frame();
	Frame f = new Frame("����ϼ");
	//f.setTitle("HelloWorld");
	f.setSize(400,300);//����
	f.setLocation(400,200);
	//����һ���������ô���ɼ�
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
