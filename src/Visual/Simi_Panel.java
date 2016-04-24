package Visual;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Simi_Panel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Simi_Panel(){
		super.revalidate();
	}
	
	
	
    public Simi_Panel(JTextArea t, Color b){
    	    	
    	this.content = t ;  //pass object t to content;
    	
    	content.setBackground(b);
    	content.setLineWrap(true);
 	    content.setWrapStyleWord(true);  // set default attributes of content
 	    
 	    JScrollPane Simi_Panel_Scroll = new JScrollPane(content);  // Automatically add scroll bar to this content
 	    
 	      super.add(Simi_Panel_Scroll);  // add scroll bar to show it
 	    
 	      super.revalidate();// Revalidated once painted 
    }
    
   
    
  public Simi_Panel(JButton B, Color b){
      	  	
    	this.Button = B ;  //pass object t to button;		
		Button.setBackground(b);
		add(Button);  // set default attributes of content
	    
 	    super.revalidate();// Revalidated once painted 
    }
  
  
  
  public Simi_Panel(Color b){
	
  	setBackground(b);
    super.revalidate();// Revalidated once painted 
  }
  
    
    public void setSizeText(int x, int y){content.setSize(x, y);} 
   
    public void setSizeButton(int x, int y){Button.setSize(x, y);}  
    
  
    
      private JTextArea content;
      private JButton   Button;
}
