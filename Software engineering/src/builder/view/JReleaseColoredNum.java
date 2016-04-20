package builder.view;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import builder.controller.AddColoredNumController;
import builder.controller.ReleaseColorController;
import builder.model.ColoredNumber;
import builder.model.LevelEditor;
import builder.model.LevelEditorState;
import builder.model.Release;
import builder.move.ReleaseColorMove;
/**
 * This class represent a view to config the coloredNumber of the release board
 * @author lthoang
 *
 */
public class JReleaseColoredNum extends JPanel {
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JTextField textField_3;
	JTextField textField_4;
	JTextField textField_5;
	Color colorNum;
	LevelEditor editor;
	JComboBox comboBox;
	LevelEditorView lev;
	
	public JReleaseColoredNum(LevelEditor editor, LevelEditorView lev) {
		setLayout(null);
		this.editor = editor;
		this.lev = lev;
		init();
	}
	
	void init(){
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Yellow", "Orange", "Pink"}));
		comboBox.addActionListener(new ReleaseColorController(comboBox, this, editor));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(6, 6, 118, 27);
		add(comboBox);
		
		JLabel lblNewLabel = new JLabel("1");
		lblNewLabel.setBounds(63, 45, 22, 16);
		add(lblNewLabel);
		
		JLabel label = new JLabel("2");
		label.setBounds(63, 73, 22, 16);
		add(label);
		
		JLabel label_1 = new JLabel("3");
		label_1.setBounds(63, 101, 22, 16);
		add(label_1);
		
		JLabel label_2 = new JLabel("5");
		label_2.setBounds(164, 73, 22, 16);
		add(label_2);
		
		JLabel label_3 = new JLabel("4");
		label_3.setBounds(164, 45, 22, 16);
		add(label_3);
		
		JLabel label_4 = new JLabel("6");
		label_4.setBounds(164, 101, 22, 16);
		add(label_4);

		
		textField = new JTextField();
		textField.setBounds(97, 40, 55, 26);
		textField.setName("1");
		add(textField);
		textField.addActionListener(new AddColoredNumController(this, editor, lev, textField));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(97, 68, 55, 26);
		textField_1.setName("2");
		textField_1.addActionListener(new AddColoredNumController(this, editor, lev, textField_1));
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(97, 96, 55, 26);
		textField_2.setName("3");
		textField_2.addActionListener(new AddColoredNumController(this, editor, lev, textField_2));
		add(textField_2);
		textField_2.setColumns(10);
				
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(198, 40, 55, 26);
		textField_3.addActionListener(new AddColoredNumController(this, editor, lev, textField_3));
		textField_3.setName("4");
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(198, 68, 55, 26);
		textField_4.addActionListener(new AddColoredNumController(this, editor, lev, textField_4));
		textField_4.setName("5");
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(198, 96, 55, 26);
		textField_5.setName("6");
		textField_5.addActionListener(new AddColoredNumController(this, editor, lev, textField_5));
		add(textField_5);
		if (editor.getLevelEditorType().equals(LevelEditorState.RELEASE)){
			Release r = (Release) editor;
			HashMap<String, ColoredNumber> h = r.getColoredNum();
			String colorString = (String) comboBox.getSelectedItem();
			textField.setText(Integer.toString(h.get(colorString + 1).getPosition()));
			textField_1.setText(Integer.toString(h.get(colorString + 2).getPosition()));
			textField_2.setText(Integer.toString(h.get(colorString + 3).getPosition()));
			textField_3.setText(Integer.toString(h.get(colorString + 4).getPosition()));
			textField_4.setText(Integer.toString(h.get(colorString + 5).getPosition()));
			textField_5.setText(Integer.toString(h.get(colorString + 6).getPosition()));
		}
	}
	
	public Color getColorNum() {
		return colorNum;
	}
	
	public String getColorString(){
		if (colorNum.equals(Color.YELLOW)){
			return "Yellow";
		} else if (colorNum.equals(Color.PINK)){
			return "Pink";
		} else if (colorNum.equals(Color.ORANGE)){
			return "Orange";
		}
		return "";
	}
	
	public void setColorNum(Color colorNum) {
		this.colorNum = colorNum;
	}

	public void update(){
		if (editor.getLevelEditorType().equals(LevelEditorState.RELEASE)){
			Release r = (Release) editor;
			HashMap<String, ColoredNumber> h = r.getColoredNum();
			String colorString = (String) comboBox.getSelectedItem();
			textField.setText(Integer.toString(h.get(colorString + 1).getPosition()));
			textField_1.setText(Integer.toString(h.get(colorString + 2).getPosition()));
			textField_2.setText(Integer.toString(h.get(colorString + 3).getPosition()));
			textField_3.setText(Integer.toString(h.get(colorString + 4).getPosition()));
			textField_4.setText(Integer.toString(h.get(colorString + 5).getPosition()));
			textField_5.setText(Integer.toString(h.get(colorString + 6).getPosition()));
		}

	}
	
}
