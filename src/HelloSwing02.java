import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class HelloSwing02 {
  public static void main(String[] args) {
    JFrame frame = new JFrame("HelloSwing - Frame Title");
    frame.getContentPane().setLayout(new GridLayout(4,3));                                          
    
    JButton ButtonArray[];  //button array
    ButtonArray = new JButton[12];
    Color colors[]={Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW,Color.MAGENTA,Color.CYAN,Color.WHITE,Color.BLACK,Color.GRAY,Color.LIGHT_GRAY,Color.DARK_GRAY,Color.PINK,Color.ORANGE};
    ActionListener genericAL;
    Random rand = new Random();

    for(int i = 0; i < 12; i++) 
    {
    	String tt=String.format("%02d",i);
    	ButtonArray[i] = new JButton(tt);
    }

    for(int i=0;i<12;i++)
    {
    	frame.add(ButtonArray[i]);
    }
    
    genericAL = new ActionListener() 
    { 
    	public void actionPerformed(ActionEvent e) 
    	 {    
       	   if (e.getSource() instanceof JButton) 
       	      {
//                String ButtonString = ((JButton) e.getSource()).getText();
       	        
                ((JButton) e.getSource()).setBackground(colors[rand.nextInt(12)]);
               }
    	  }
     };
  
     for(int i=0;i<12;i++)
     {
     	ButtonArray[i].addActionListener(genericAL);
     }
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
    
    ///////////////////// Extend /////////
    
    frame.setSize(300,200);
    frame.setLocationRelativeTo(null);

  }
  
  
}