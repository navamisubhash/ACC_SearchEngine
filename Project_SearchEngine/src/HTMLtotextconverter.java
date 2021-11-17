//package Assignment4;
 
import java.io.File;
import java.io.FileWriter;

import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  

public class HTMLtotextconverter {

	public void htmltotext(final File files) {
	    try {
	    	
	    	FileWriter filewriter;
	    	{
	    		//
	    		File webpage = new File("C:/Users/navam/OneDrive/Desktop/UWindsor/Sem_1/ACC/project/"+files.getName());
	    		
	    		//call the parse function in jsoup
	    		Document d = Jsoup.parse(webpage,"UTF-8");
	    		
	    		filewriter=new FileWriter("C:\\Users\\navam\\OneDrive\\Desktop\\UWindsor\\Sem_1\\ACC\\project\\ConvertedFiles\\"+files.getName()+".txt");    
	    		
	    		//write text file
	    		filewriter.write(d.text());  
	    		
	    		//close FW
	    		filewriter.close();    
	    	}
	    	
	    }
	    
	    catch (Exception e){
	    System.out.println(e);
	    }
	    
	}
	
	public static void main(String [] args)
	{
		final File webpages = new File("C:/Users/navam/OneDrive/Desktop/UWindsor/Sem_1/ACC/project/");
		
		HTMLtotextconverter htmlobj = new HTMLtotextconverter();
		
		for (final File files : webpages.listFiles()) 
			
		{
			htmlobj.htmltotext(files);
		}
		
		System.out.println("Done converting all the files");
	}

	
}
