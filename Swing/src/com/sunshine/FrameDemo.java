package com.sunshine;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameDemo {
public static void main(String[] args) {
	//��������
	//Frame f = new Frame();
	Frame f = new Frame("����ϼ");
	//f.setTitle("HelloWorld");
	f.setSize(400,300);//����
	f.setLocation(400,200);
	f.setLayout(new FlowLayout());
	final 	TextField tf = new TextField(20);
	//������ť
	Button bu = new Button("����ת��");
	//�����ı���
	TextArea ta = new TextArea(10,40);
	//�������ӵ�����
	f.add(tf);
	f.add(bu);
	f.add(ta);
	f.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			super.windowClosing(e);
			System.exit(0);
		}
	});
	bu.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String tf_str = tf.getText().trim();
			//����ı���
			tf.setText("");
			//ta.setText(tf_str);
			//׷�Ӻͻ���
			ta.append(tf_str+"\r\n");
			tf.requestFocus();
			//tf.getFocusListeners();
		}
	});
	//����һ���������ô���ɼ�
	f.setVisible(true);
	
	//System.out.println("helloworld");
}
}
