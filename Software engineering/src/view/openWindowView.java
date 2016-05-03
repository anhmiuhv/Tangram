package view;
import javax.swing.JOptionPane;


/**
 * this class representing the confirmation window dialog
 * @author kdai
 * @author jshen3
 * @author xwang111 
 *
 */
public class openWindowView {
	String str;
	
	/**
	 * create this class
	 * @param str
	 */
	public openWindowView(String str){
		this.str =str;
	}
	
	
	/**
	 * get the answer of the user
	 * @return true if ok to close
	 */
	public boolean valid(){
		  int i=JOptionPane.showConfirmDialog(null, str, "Kabasuji:", JOptionPane.YES_NO_OPTION);
		  if(i==JOptionPane.OK_OPTION){
		  	return true;
		  }else{
			  return false;
		  }
		
	}

}
