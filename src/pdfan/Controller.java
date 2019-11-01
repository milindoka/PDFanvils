package pdfan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import com.itextpdf.text.DocumentException;

public class Controller {

    private View view;
    private ActionListener GenericActionListener;
    private monthlyReportpdf MR=new monthlyReportpdf();
    
    public Controller()
    {
    	view=new View();
    }
    
    public void contol()
    {        
        GenericActionListener = new ActionListener()
        {
              public void actionPerformed(ActionEvent e) 
              {   if (e.getSource() instanceof JButton) 
       	      {
                  String text = ((JButton) e.getSource()).getText();
         	        ActionTerminal(text); 
                 } 
              }
        };                
   
        for(int i=0;i<100;i++)  view.GetButton(i).addActionListener(GenericActionListener);
    }
    
    private void ActionTerminal(String ButtonString)
    {
    	if(ButtonString.contains("00")) { 
    		try {
    			MR.AttendanceReportPdf();
    		} catch (DocumentException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        
    		
    		System.out.println("00"); return; }
    	if(ButtonString.contains("01")) {  return; }
    	if(ButtonString.contains("02")) {  return; }
    	if(ButtonString.contains("03")) {  return; }
    	if(ButtonString.contains("04")) {  return; }
    	if(ButtonString.contains("05")) {  return; }
    	if(ButtonString.contains("06")) {  return; }
    }    
}
