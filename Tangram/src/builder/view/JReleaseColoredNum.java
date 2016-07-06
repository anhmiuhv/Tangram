package builder.view;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import builder.controller.AddColoredNumController;
import builder.controller.ReleaseColorController;
import builder.controller.getCoordinateModeController;
import builder.model.ColoredNumber;
import builder.model.LevelEditor;
import builder.model.LevelEditorState;
import builder.model.Release;

import javax.swing.JButton;
/**
 * This class represent a view to config the coloredNumber of the release board
 * @author lthoang
 *
 */
public class JReleaseColoredNum extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8416096092554032428L;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JTextField textField_3;
	JTextField textField_4;
	JTextField textField_5;
	Color colorNum;
	LevelEditor editor;
	JComboBox<String> comboBox;
	LevelEditorView lev;
	JButton btnNewButton;
	JButton button;
	JButton button_1;
	JButton button_2;
	JButton button_3;
	JButton button_4;
	int chosenNumber;
	
	/**
	 * set chosen number
	 * @param chosenNumber the chosen number
	 */
	public void setChosenNumber(int chosenNumber) {
		this.chosenNumber = chosenNumber;
	}

	/**
	 * get the chosen number
	 * @return chosen number
	 */
	public int getChosenNumber() {
		return chosenNumber;
	}

	/**
	 * create the release color num config
	 * @param editor model leveleditor
	 * @param lev parent view
	 */
	public JReleaseColoredNum(LevelEditor editor, LevelEditorView lev) {
		setLayout(null);
		this.editor = editor;
		this.lev = lev;
		init();
	}
	
	private void init(){

		
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
		textField_3.setBounds(208, 40, 55, 26);
		textField_3.addActionListener(new AddColoredNumController(this, editor, lev, textField_3));
		textField_3.setName("4");
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(208, 68, 55, 26);
		textField_4.addActionListener(new AddColoredNumController(this, editor, lev, textField_4));
		textField_4.setName("5");
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(208, 96, 55, 26);
		textField_5.setName("6");
		textField_5.addActionListener(new AddColoredNumController(this, editor, lev, textField_5));
		add(textField_5);
				
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Yellow", "Orange", "Pink"}));
		comboBox.addActionListener(new ReleaseColorController(comboBox, this, editor));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(6, 6, 118, 27);
		add(comboBox);
		
		btnNewButton = new JButton("1");
		btnNewButton.setBounds(35, 40, 60, 29);
		btnNewButton.addActionListener(new getCoordinateModeController(lev, btnNewButton, editor, this));
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);
		add(btnNewButton);
		
		button = new JButton("2");
		button.setBounds(35, 68, 60, 29);
		button.setOpaque(true);
		button.setBorderPainted(false);
		button.addActionListener(new getCoordinateModeController(lev, button, editor, this));
		add(button);
		
		button_1 = new JButton("3");
		button_1.setBounds(35, 96, 60, 29);
		button_1.setOpaque(true);
		button_1.setBorderPainted(false);
		button_1.addActionListener(new getCoordinateModeController(lev, button_1, editor, this));
		add(button_1);
		
		button_2 = new JButton("4");
		button_2.setBounds(147, 40, 60, 29);
		button_2.setOpaque(true);
		button_2.setBorderPainted(false);
		button_2.addActionListener(new getCoordinateModeController(lev, button_2, editor, this));
		add(button_2);
		
		button_3 = new JButton("5");
		button_3.setBounds(147, 68, 60, 29);
		button_3.setOpaque(true);
		button_3.setBorderPainted(false);
		button_3.addActionListener(new getCoordinateModeController(lev, button_3, editor, this));
		add(button_3);
		
		button_4 = new JButton("6");
		button_4.setBounds(147, 96, 60, 29);
		button_4.setOpaque(true);
		button_4.setBorderPainted(false);
		button_4.addActionListener(new getCoordinateModeController(lev, button_4, editor, this));
		add(button_4);
		
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
	
	/**
	 * get the color number
	 * @return colored number
	 */
	public Color getColorNum() {
		return colorNum;
	}
	
	/**
	 * get the color string
	 * @return color string
	 */
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
	
	/**
	 * set the color
	 * @param colorNum color
	 */
	public void setColorNum(Color colorNum) {
		this.colorNum = colorNum;
	}

	/**
	 * update the view
	 */
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

	/**
	 * get the chosen text field
	 * @return text field
	 */
	public JTextField getTextField(){
		switch (this.chosenNumber){
		case 1:
			return textField;
		case 2:
			return textField_1;
		case 3:
			return textField_2;
		case 4:
			return textField_3;
		case 5:
			return textField_4;
		case 6:
			return textField_5;
		}
		return null;
	}
	
	/**
	 * reset all the background of the button
	 */
	public void setBackgroundButton() {
		this.btnNewButton.setBackground(null);
		this.button.setBackground(null);
		this.button_1.setBackground(null);
		this.button_2.setBackground(null);
		this.button_3.setBackground(null);
		this.button_4.setBackground(null);
		
	}
}
