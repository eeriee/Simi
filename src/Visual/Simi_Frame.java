package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import Simi.Article;
import Simi.CosineAlgorithm;
import Simi.SimpleAlgorithm;
import Simi.StemmingAlgorithm;

public class Simi_Frame extends JFrame{
	
	
	private static final long serialVersionUID = 1L;
	
	public Simi_Frame() throws Exception{
		
		
		setSize(Default_Width,Default_Height);
		setLocationByPlatform(true);
		setIconImage(Simi_Icon);
		setTitle("Simi");
		
		
		   Container Main_Container =  getContentPane();
		  
		   Simi_Frame_Centre.setLayout(new GridLayout(5,1));
		   Simi_Frame_Centre.add(Simi_Input,Simi_Green);
	       Simi_Frame_West.setBackground(Simi_Green); 
	       Simi_Frame_East.setBackground(Simi_Green);   
		   Simi_Input.setLayout(new GridLayout(2,2));
		   Simi_Input.add(Input_Button_A,Simi_Green);
		   Simi_Input.add(TextArea_Input_A,Simi_Green);
		   Simi_Input.add(Input_Button_B,Simi_Green);
		   Simi_Input.add(TextArea_Input_B,Simi_Green);
		   
		   Main_Container.add(Simi_Frame_North,BorderLayout.NORTH);
		   Main_Container.add(Simi_Frame_South,BorderLayout.SOUTH);
		   Main_Container.add(Simi_Frame_West,BorderLayout.WEST);
		   Main_Container.add(Simi_Frame_East,BorderLayout.EAST);
		   Main_Container.add(Simi_Frame_Centre,BorderLayout.CENTER);
		
					
		Simi_Simple_Result_Jbutton.setForeground(Color.BLACK);	
		Simi_Simple_Result_Jbutton.setSize(ActionButton.getWidth(), ActionButton.getHeight());
		
				
		Simi_Cosine_Result_Jbutton.setForeground(Color.BLACK);	
		Simi_Cosine_Result_Jbutton.setSize(ActionButton.getWidth(), ActionButton.getHeight());
		
		
	    ActionButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Simi_Frame_Centre.add(Simi_Simple_Result_Jbutton);
				Simi_Simple_Result_Jbutton.setBackground(Simi_Green);
				Simi_Simple_Result_Jbutton.setFont(new Font("sansserif",Font.BOLD,30));
				
				Simi_Frame_Centre.add(Simi_Cosine_Result_Jbutton);
				Simi_Cosine_Result_Jbutton.setBackground(Simi_Green);
				Simi_Cosine_Result_Jbutton.setFont(new Font("sansserif",Font.BOLD,30));
				
				Simi_Frame_Centre.add(Simi_Stem_Result_Jbutton);
				Simi_Stem_Result_Jbutton.setBackground(Simi_Green);
				Simi_Stem_Result_Jbutton.setFont(new Font("sansserif",Font.BOLD,30));
				Simi_Frame_Centre.revalidate();	
			                                            }
	    	
	    	
	        });
	}
  

	  
	  private Color Simi_Green = new Color(32,158,133);
	  private  Color Simi_Yellow = new Color(213,209,151);
	
	  private String inputtest1= "src\\Article\\RAW.txt";
	  private String inputtest2= "src\\Article\\REF.txt";
	  private String Icon_URL="src\\Pic\\icon.png";
	  private String Icon_URL1="src\\Pic\\icon1.png";
	  
      private JTextArea TextArea_Input_A =new JTextArea(inputtest1);
      private JTextArea TextArea_Input_B =new JTextArea(inputtest2);
      
      private Image Simi_Icon=Toolkit.getDefaultToolkit().getImage(Icon_URL);
	  private  JButton ActionButton= new JButton(new ImageIcon(Icon_URL));
	  private JButton Input_Button_A      =  new JButton("Your RAW File Link:");
	  private JButton Input_Button_B      =  new JButton("Your REF File Link:");
      
	  private final int Default_Width = (int)(Toolkit.getDefaultToolkit().getScreenSize().width/1.414);
	  private final int Default_Height= (int)(Toolkit.getDefaultToolkit().getScreenSize().height/1.414);
	  
 
	  Article A = new Article (TextArea_Input_A.getText().trim());
	  Article B = new Article (TextArea_Input_B.getText().trim());
	  
	 
	  SimpleAlgorithm   Try1=  new SimpleAlgorithm  (A,B);
	  CosineAlgorithm   Try2=  new CosineAlgorithm  (A,B);
	  StemmingAlgorithm Try3=  new StemmingAlgorithm(A,B);
	   
	  private Simi_Panel Simi_Frame_West   = new Simi_Panel(new JTextArea(A.getContentString(),50,40),Simi_Yellow); 
	  private Simi_Panel Simi_Frame_East   = new Simi_Panel(new JTextArea(B.getContentString(),50,40),Simi_Yellow);
	  private Simi_Panel Simi_Frame_Centre = new Simi_Panel(ActionButton,Simi_Green);
	  private Simi_Panel Simi_Frame_South =  new Simi_Panel(Simi_Green);
	  private Simi_Panel Simi_Frame_North =  new Simi_Panel(Simi_Green);
	  private Simi_Panel Simi_Input       =  new Simi_Panel(Simi_Green);
	  
	  final JButton Simi_Simple_Result_Jbutton = new JButton("Simple Similarity is: "+Try1.Compare().subSequence(0, 5)+"%");
	  final JButton Simi_Cosine_Result_Jbutton = new JButton("Cosine Similarity is: "+Try2.Compare().subSequence(0, 5)+"%");
	  final JButton Simi_Stem_Result_Jbutton = new JButton("Stem Similarity is: "+Try3.Compare().subSequence(0, 5)+"%");
} 



