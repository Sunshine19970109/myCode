package com.itcast_04;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

/*需求: 把按钮添加到窗体，并对按钮添加一个点击事件
 * 1 创建窗体对象
 * 2创建按钮对象
 * 3把按钮添加到窗体中
 * 4窗体显示
 * */
public class FrameDemo {
	public static void main(String[] args) {
		//创建窗体
		Frame f = new Frame("添加按钮");
		//设置属性
		f.setBounds(400,200,400,300);
		f.setLayout(new FlowLayout());
		//创建按钮对象
		Button bu = new Button("点我啊");
		bu.setSize(20,40);
		//bu.setName("我是按钮");
		//把窗体添加到窗体
		f.add(bu);
		//设置窗体关闭
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
				System.out.println("你再点试试");
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
