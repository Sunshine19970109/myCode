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
	Frame f = new Frame("��������������ַ�");
	f.setBounds(400,200,400,300);
	f.setLayout(new FlowLayout());
	f.setVisible(true);
	//����Lable��ǩ�¼�
	Label label = new Label("���������qq���룬������������֣�����������");
	TextField tf = new TextField(40);
	f.add(label);
	f.add(tf);
	//���ı�������¼�
	tf.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyPressed(e);
			//����������ַ���ȡ��
			//�Ȼ�ȡ�ַ������ж��ַ���ȡ���¼�
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
