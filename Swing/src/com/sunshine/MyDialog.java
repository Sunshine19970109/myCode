package com.sunshine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class MyDialog extends JDialog{
	public MyDialog(MyFrame frame){
		//ʵ����һ��JDialog
		//JDialog jg = new JDialog();
		super(frame,"���ǵ�һ��JDialog����",true);
		Container container = getContantPane();
		container.add(new JLabel("����һ���Ի���"));
		setBounds(120,120,100,100);
		
	}

	private Container getContantPane() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
public class MyFrame extends JFrame{
	public static void main(String args[]) {
		new MyFrame();
	}
	public MyFrame(){
		Container container =  getContentPane();
		container.setLayout(null);
		JLabel jl = new JLabel("����һ��JFrame����");
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(jl);
		JButton JB = new JButton("�����Ի���");
		JB.setBounds(10,10,100,21);
		JB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//ʹMyJDialog����ɼ�
				new MyDialog(MyFrame.this).setVisible(true);
			}
		});
		container.add(JB);
		//container.setBackground(Color_white);
	}
}
