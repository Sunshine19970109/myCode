package cn.itcast_05;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.TextField;

public class Frame {


public static void main(String[] args) {
	//chuangjian �������
	Frame f = new java.awt.Frame();
	//���ô������ԺͲ���
	f.setBounds(400,200,400,300);
	
	f.setLayout(new FlowLayout);
	
	//�����ı���
	
	f.setVisible(true);
}
}
