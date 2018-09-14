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
	//创建对象
	//Frame f = new Frame();
	Frame f = new Frame("林青霞");
	//f.setTitle("HelloWorld");
	f.setSize(400,300);//像素
	f.setLocation(400,200);
	f.setLayout(new FlowLayout());
	final 	TextField tf = new TextField(20);
	//创建按钮
	Button bu = new Button("数据转移");
	//创建文本域
	TextArea ta = new TextArea(10,40);
	//把组件添加到窗体
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
			//清空文本域
			tf.setText("");
			//ta.setText(tf_str);
			//追加和换行
			ta.append(tf_str+"\r\n");
			tf.requestFocus();
			//tf.getFocusListeners();
		}
	});
	//调用一个方法，让窗体可见
	f.setVisible(true);
	
	//System.out.println("helloworld");
}
}
