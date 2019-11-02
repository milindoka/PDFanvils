package pdfan;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class monthlyReportpdf {
	
	ArrayList<String> roll=new ArrayList<String>();//creating new generic arraylist  
	ArrayList<String> attendance=new ArrayList<String>();//creating new generic arraylist
	//fylename=path+"/"+ReportName+"-Science.txt";
	
	int strength=35,requiredtables=3;
	
	
	 Font normal = new Font(Font.FontFamily.TIMES_ROMAN, 10,
             Font.NORMAL);

	
	public String getJarPath()
    {
    	File f = new File(System.getProperty("java.class.path"));
     	File dir = f.getAbsoluteFile().getParentFile();
        String path=dir.toString();
     	return  path;
    }

	void FillMarksArray()
	{   roll.removeAll(roll);
	    attendance.removeAll(attendance);
        int x=0;
        String str;
		Random ran = new Random();
		for(int i=0;i<strength;i++)
		  {
			x = ran.nextInt(101);
			str=String.format("%d", 5001+i);
			roll.add(str); 
			str=String.format("%02d", x);
			attendance.add(str);
			
		  }
	
	}
	
	
	 void AttendanceReportPdf() throws DocumentException, IOException
	    {   if(strength>200) return;
		 	requiredtables=strength/35;
	        if(strength%35!=0) requiredtables++;

	        String filename="monthlyAttendance.pdf";
	    	Document document = new Document(PageSize.A4.rotate());
	    	document.setMargins(50, 10, 25, 25);
	    	PdfWriter.getInstance(document, new FileOutputStream(filename));
	    	document.open();
	    	
	     //    com.itextpdf.text.Font NORMAL = new com.itextpdf.text.Font(FontFamily.TIMES_ROMAN, 12);
	        AddHeader(document);	FillMarksArray();
	        AttendanceGrid(document);
         
//	        AddFooter(document);
	        
	        
	        document.close();
	    }
	   	

  void AddHeader(Document document) throws DocumentException, IOException
  {
   PdfPTable table = new PdfPTable(3);
   PdfPCell cell = new PdfPCell(new Phrase(" "));
   cell.setBorder(PdfPCell.NO_BORDER);
   table.setWidthPercentage(95);
   table.addCell(cell);
  	
  	
   cell = new PdfPCell(new Phrase("SIWS College"));cell.setBorder(PdfPCell.NO_BORDER);
   cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
   table.addCell(cell);
  

   cell = new PdfPCell(new Phrase(" "));cell.setBorder(PdfPCell.NO_BORDER);
   table.addCell(cell);

   cell = new PdfPCell(new Phrase("Name of Teacher :"));cell.setBorder(PdfPCell.NO_BORDER);
   cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
  	table.addCell(cell);


   cell = new PdfPCell(new Phrase("Class-Div :"));cell.setBorder(PdfPCell.NO_BORDER);
   cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
  	table.addCell(cell);
  	
  	
  	cell = new PdfPCell(new Phrase("Subject :"));cell.setBorder(PdfPCell.NO_BORDER);
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);cell.setBorder(PdfPCell.NO_BORDER);
  	table.addCell(cell);

  	cell = new PdfPCell(new Phrase("Date : 23/02/18"));cell.setBorder(PdfPCell.NO_BORDER);
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
  	table.addCell(cell);
    
  	table.setSpacingAfter(10f);
    document.add(table);
		  
  }
	  
	  void AttendanceGrid(Document document) throws DocumentException, IOException
	  { 
			
		   float col[]={4,8,2,2,2,2,2,2,2,2,2,2,
				            2,2,2,2,2,2,2,2,2,2,
				            2,2,2,2,2,2,2,2,2,2,
				            2,4,4};
		  	
		  	//////////   TITLE ROW  ///////////////////////
		  	
		  	PdfPTable table2 = new PdfPTable(col);
		  	 table2.setWidthPercentage(95);
		   PdfPCell cell = new PdfPCell(new Phrase("Sr No",normal));
		    cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		    cell.setPaddingBottom(5f);
		    table2.addCell(cell);  	
		  	
		    cell = new PdfPCell(new Phrase("Roll No",normal));
		    cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		    //cell.setBorder(PdfPCell.NO_BORDER);
		    table2.addCell(cell);
		   
		    String dateno;
		    for(int j=0;j<31;j++)
		    {
				    dateno=String.format("%d",j+1);
				    cell = new PdfPCell(new Phrase(dateno,normal));
				    cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
				    cell.setPaddingBottom(5f);
				    table2.addCell(cell);
		    }
		    
		    cell = new PdfPCell(new Phrase("Total",normal));
		    cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		    //cell.setBorder(PdfPCell.NO_BORDER);
		    table2.addCell(cell);
		    
		    cell = new PdfPCell(new Phrase(" % ",normal));
		    cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		    //cell.setBorder(PdfPCell.NO_BORDER);
		    table2.addCell(cell);
		    	
            ////////////////// END OF TITLE ROW		    
		    
		    ////////////// REMAING TABLE ROWS
		    
		    String srno;	
		  for (int i=0;i<strength;i++)	
		  {
	    	srno=String.format("%d",i+1);
		    cell = new PdfPCell(new Phrase(srno,normal));
		    cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		    cell.setPaddingBottom(5f);
		    table2.addCell(cell);
		    
		    cell = new PdfPCell(new Phrase(roll.get(i),normal));
		    cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		    //cell.setBorder(PdfPCell.NO_BORDER);
		    table2.addCell(cell);
		  	
		     for(int j=0;j<31;j++)
		          {
				    cell = new PdfPCell(new Phrase("P",normal));
				    cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
				    cell.setPaddingBottom(5f);
				    table2.addCell(cell);
		          }
		     
		       cell = new PdfPCell(new Phrase(" ",normal));
			    cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			    //cell.setBorder(PdfPCell.NO_BORDER);
			    table2.addCell(cell);
			    
			    cell = new PdfPCell(new Phrase(" ",normal));
			    cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			    //cell.setBorder(PdfPCell.NO_BORDER);
			    table2.addCell(cell);
		     
		  }

	
		  	
		    document.add(table2);
				  
		  
		  
		  
		  
		  /*
		  
		  PdfPTable table1 = new PdfPTable(35);
	      table1.setWidthPercentage(100);
  		  PdfPCell cellfortable1 = new PdfPCell();
  		  cellfortable1.setPadding(0);
  		  table1.addCell(cellfortable1);
  		  
          for(int aw = 0; aw < 35*31; aw++){
              table1.addCell("P");
          }
          
 
     	  document.add(table1);	
*/
	  }
	  

	 void FillTable(PdfPTable tbl)
	 {
		 PdfPCell cell = new PdfPCell(new Phrase(""));
		  cell.setPaddingBottom(4f);
		  int index = 0;
//		  
//	  	  cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//	  	  tbl.addCell(cell);
//	  	  cell = new PdfPCell(new Phrase("MRK"));
////	  	  cell.setPaddingBottom(4f);
//	  	  cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//	  	  tbl.addCell(cell);
	  	
	  	for(int i=0;i<35;i++)
	  	{ if(i+index*35>=strength) break;
	  
	  	  cell = new PdfPCell(new Phrase(roll.get(i+index*35)));
	  	  cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	      cell.setPaddingBottom(3f);
	      cell.setPaddingTop(1f);
		  tbl.addCell(cell);
		  cell = new PdfPCell(new Phrase(attendance.get(i+index*35)));
		  cell.setPaddingBottom(3f);	
		  cell.setPaddingTop(1f);
		  cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		  
		  tbl.addCell(cell);
	  		
	  	}
	  			 
	 }
	 

}