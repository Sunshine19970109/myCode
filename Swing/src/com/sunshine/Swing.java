package com.sunshine;
import java.awt.*;
import javax.swing.*;
public class Swing extends JFrame{
           /**
	 * 
	 */
	public static void main(String[] args){
 	   new Swing().CreatJFrame("����һ��JFrame����");
    }
	private static final long serialVersionUID = 1L;
		public void CreatJFrame(String title){
        	   JFrame jf = new JFrame(title);
        	   Container container = jf.getContentPane();//��ȡһ������
        	   JLabel jl = new JLabel("����һ��JFrame����");//����һ��JLabel��ǩ
        	   //ʹ��ǩ�ϵ����־���
        	   jl.setHorizontalAlignment(SwingConstants.CENTER);
        	   container.add(jl);
        	   container.setBackground(Color.green);
        	   jf.setVisible(true);
        	   jf.setSize(200,150);
        	   //���ô���رշ�ʽ
        	   jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
           }
           
}
