package com.sunshine;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public interface FrameDemo3 {
public static void main(String[] args) {
	Frame f = new Frame("��������ر��¼�");
	f.setBounds(400,200,400,300);
	//�ô���ر�
	//�¼�Դ  			�¼�����		�¼�		�¼�����
	f.addWindowListener(new WindowListener() {
		
		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		
		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	//������
	//�ӿ���Ҫ��д���з���	1дһ��ʵ���ⲿ��	2дһ�������ڲ���
	f.setVisible(true);
}
}
