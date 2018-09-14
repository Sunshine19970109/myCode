package com.sunshine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class MyDialog extends JDialog{
	public MyDialog(MyFrame frame){
		//实例化一个JDialog
		//JDialog jg = new JDialog();
		super(frame,"这是第一个JDialog窗体",true);
		Container container = getContantPane();
		container.add(new JLabel("这是一个对话框"));
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
		JLabel jl = new JLabel("这是一个JFrame窗体");
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(jl);
		JButton JB = new JButton("弹出对话框");
		JB.setBounds(10,10,100,21);
		JB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//使MyJDialog窗体可见
				new MyDialog(MyFrame.this).setVisible(true);
			}
		});
		container.add(JB);
		//container.setBackground(Color_white);
	}
}
