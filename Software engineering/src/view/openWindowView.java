package view;
import javax.swing.JOptionPane;



public class openWindowView {
	String str;
	
	public openWindowView(String str){
		this.str =str;
	}
	
	
	public boolean valid(){
		  int i=JOptionPane.showConfirmDialog(null, str, "Kabasuji:", JOptionPane.YES_NO_OPTION);
		  if(i==JOptionPane.OK_OPTION){
		  	return true;
		  }else{
			  return false;
		  }
		
	}

}
