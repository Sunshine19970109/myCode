package com.itcast_04;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

/*����: �Ѱ�ť��ӵ����壬���԰�ť���һ������¼�
 * 1 �����������
 * 2������ť����
 * 3�Ѱ�ť��ӵ�������
 * 4������ʾ
 * */
public class FrameDemo {
	public static void main(String[] args) {
		//��������
		Frame f = new Frame("��Ӱ�ť");
		//��������
		f.setBounds(400,200,400,300);
		f.setLayout(new FlowLayout());
		//������ť����
		Button bu = new Button("���Ұ�");
		bu.setSize(20,40);
		//bu.setName("���ǰ�ť");
		//�Ѵ�����ӵ�����
		f.add(bu);
		//���ô���ر�
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.exit(0);
			}
		});
		bu.addActionListener(new Action() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("���ٵ�����");
			}
			
			@Override
			public void setEnabled(boolean b) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void removePropertyChangeListener(PropertyChangeListener listener) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void putValue(String key, Object value) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Object getValue(String key) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void addPropertyChangeListener(PropertyChangeListener listener) {
				// TODO Auto-generated method stub
				
			}
		});
		f.setVisible(true);
}
}
