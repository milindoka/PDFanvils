package pdfan;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
	ArrayList<String> attendanceLines=new ArrayList<String>();//creating new generic arraylist
	ArrayList<String> APchain=new ArrayList<String>();//creating new generic arraylist
	
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
	

	void FillRollArray()
	{   roll.removeAll(roll);
	    APchain.removeAll(APchain);	   
	String temp[],rolltemp[];
	
	
	
	//assert 4 parts in first split 
	temp=attendanceLines.get(0).split("#");
	rolltemp=temp[2].split(",");
	
	  for (int x=0;x<rolltemp.length;x++)
	    { roll.add(rolltemp[x]);
	      APchain.add("");
	    }
	}

	
	void LoadAttendanceLines(String division, String month)
	{  
	    attendanceLines.removeAll(attendanceLines);
	    attendanceLines.add("02/11/19 - Sat - 11:53#IX-A#5,25,197,331,565,1012#APPPAP");
	    attendanceLines.add("03/11/19 - Sun - 20:23#IX-A#5,25,197,331,565,1012#PPAAAP");
	    attendanceLines.add("08/11/19 - Sat - 11:53#IX-A#5,25,197,331,565,1012#APPPAP");
	    attendanceLines.add("17/11/19 - Sat - 11:53#IX-A#5,25,197,331,565,1012#APPPAP");
	    attendanceLines.add("22/11/19 - Sat - 11:53#IX-A#5,25,197,331,565,1012#APPPAP");
	    attendanceLines.add("28/11/19 - Sat - 11:53#IX-A#5,25,197,331,565,1012#APPPAP");
	    attendanceLines.add("31/11/19 - Sat - 11:53#IX-A#5,25,197,331,565,1012#APPPAP");
	}
	
	void Check_ThirtyOneDays_And_Fill_APChain()
	{ boolean datefound=false;
	  
	  for(int i=1;i<32;i++)
		{ 
		  String TwoDigitMonthDay=String.format("%02d",i);
		  datefound=false;
		  for(int j=0;j<attendanceLines.size();j++)
		  {
			  String str=attendanceLines.get(j).substring(0, 2);
			  if(str.equalsIgnoreCase(TwoDigitMonthDay))
			  {datefound=true; break;}
		  }
		  for(int k=0;k<roll.size();k++)
		  {
			String temp=APchain.get(k);
			if(datefound) 
				APchain.set(k,temp+"P");
			    else
			    APchain.set(k,temp+" ");
			   
		   }
		}
	  for(int l=0;l<APchain.size();l++)
		  System.out.println(APchain.get(l));
	}
	
	
	 void AttendanceReportPdf() throws DocumentException, IOException
	    {  LoadAttendanceLines(" ", " ");
		 
		   if(strength>200) return;
		 	requiredtables=strength/35;
	        if(strength%35!=0) requiredtables++;

	        String filename="monthlyAttendance.pdf";
	    	Document document = new Document(PageSize.A4.rotate());
	    	document.setMargins(50, 10, 25, 25);
	    	PdfWriter.getInstance(document, new FileOutputStream(filename));
	    	document.open();
	    	
	     //    com.itextpdf.text.Font NORMAL = new com.itextpdf.text.Font(FontFamily.TIMES_ROMAN, 12);
	        AddHeader(document);
	        FillRollArray();
	        Check_ThirtyOneDays_And_Fill_APChain();
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
		  for (int i=0;i<roll.size();i++)	
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
		          { String APmark=""+APchain.get(i).charAt(j);
				    cell = new PdfPCell(new Phrase(APmark,normal));
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
		  cell = new PdfPCell(new Phrase(attendanceLines.get(i+index*35)));
		  cell.setPaddingBottom(3f);	
		  cell.setPaddingTop(1f);
		  cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		  
		  tbl.addCell(cell);
	  		
	  	}
	  			 
	 }
	 

}