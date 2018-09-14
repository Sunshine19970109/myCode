package com.sunshine;
import java.awt.*;
import javax.swing.*;
public class Swing extends JFrame{
           /**
	 * 
	 */
	public static void main(String[] args){
 	   new Swing().CreatJFrame("创建一个JFrame窗体");
    }
	private static final long serialVersionUID = 1L;
		public void CreatJFrame(String title){
        	   JFrame jf = new JFrame(title);
        	   Container container = jf.getContentPane();//获取一个容器
        	   JLabel jl = new JLabel("这是一个JFrame窗体");//创建一个JLabel标签
        	   //使标签上的文字居中
        	   jl.setHorizontalAlignment(SwingConstants.CENTER);
        	   container.add(jl);
        	   container.setBackground(Color.green);
        	   jf.setVisible(true);
        	   jf.setSize(200,150);
        	   //设置窗体关闭方式
        	   jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
           }
           
}
