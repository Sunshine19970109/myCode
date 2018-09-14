package cn.itcast_07;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameDemo {
public static void main(String[] args) {
	Frame f = new Frame("不能输入非数字字符");
	f.setBounds(400,200,400,300);
	f.setLayout(new FlowLayout());
	f.setVisible(true);
	//创建Lable标签事件
	Label label = new Label("请输入你的qq号码，不许输入非数字，不信你试试");
	TextField tf = new TextField(40);
	f.add(label);
	f.add(tf);
	//给文本框添加事件
	tf.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyPressed(e);
			//如果是数字字符就取消
			//先获取字符，在判断字符，取消事件
			char ch  = e.getKeyChar();
//			System.out.println(ch);
			if(!(ch>='0'&&ch<='9')){
				e.consume();
			}
		}
	});
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
