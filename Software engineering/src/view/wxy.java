package view;

import model.Hint;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

/**
 * ��������¼�
 * ���Կ�������˫�����ʱ����һ�εĵ���ᴥ��һ�ε����¼�
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
