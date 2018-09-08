import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloSwing02 {
  public static void main(String[] args) {
    JFrame frame = new JFrame("HelloSwing - Frame Title");
    //final JLabel label = new JLabel("Hello Swing");
   // frame.getContentPane().add(label);
    
    frame.getContentPane().setLayout(new GridLayout(4,3));                                          
    
    JButton ButtonArray[];  //button array
    ButtonArray = new JButton[12];
    for(int i = 0; i < 12; i++) 
    {
    	String tt=String.format("%02d",i);
    	ButtonArray[i] = new JButton(tt);
    }

    for(int i=0;i<12;i++)
    {
    	frame.add(ButtonArray[i]);
    }

    
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
    
    ///////////////////// Extend /////////
    
    frame.setSize(300,200);
    frame.setLocationRelativeTo(null);
    

  }
}