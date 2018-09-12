package pdfan;



import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class View {
      
    private JFrame frame;

    JButton ButtonArray[];  //button array
    
    public View()
    {
    	frame = new JFrame("View - JavaAtoZ");                                    
        frame.getContentPane().setLayout(new GridLayout(20,5,7,5));      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
        frame.setSize(200,200);
        frame.setLocationRelativeTo(null);
         frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        
        //// create buttons and add them programmatically
        ButtonArray = new JButton[100];
        for(int i = 0; i < 100; i++) 
        {
        	String tt=String.format("%02d",i);
        	ButtonArray[i] = new JButton(tt);
        }

        for(int i=0;i<100;i++)
        {
        	frame.add(ButtonArray[i]);
        }
    }
    
    JButton GetButton(int i)
    {
    	return ButtonArray[i];
    }
    
    
    
}