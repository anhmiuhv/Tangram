package view;

import model.Hint;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

/**
 * 监听鼠标事件
 * 可以看出，当双击鼠标时，第一次的点击会触发一次单击事件
 * @author HAN
 *
 */
public class wxy extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7554087008285696671L;


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wxy frame = new wxy();
		frame.setTitle("MouseEvent Test");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 300, 100);
	}

}
