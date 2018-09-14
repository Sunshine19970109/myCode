package cn.itcast_05;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.TextField;

public class Frame {


public static void main(String[] args) {
	//chuangjian 窗体队形
	Frame f = new java.awt.Frame();
	//设置窗体属性和布局
	f.setBounds(400,200,400,300);
	
	f.setLayout(new FlowLayout);
	
	//创建文本框
	
	f.setVisible(true);
}
}
