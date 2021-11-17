import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.net.URL;
import java.io.BufferedWriter;
import java.io.InputStreamReader;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class web_crawler {
	public static void main(String[] args)
	{
		String url = "https://en.wikipedia.org";
		crawl(1,url, new ArrayList<String>());
		
	}	
	private static void crawl(int level, String url, ArrayList<String> visited)
	{	
		if(level <= 5)
		{	
			Document doc = request(url,visited);
			if(doc != null) {
				String title = doc.title();
				try {
				URL url_2 = new  URL(url);
				BufferedReader myreader = new BufferedReader(new InputStreamReader(url_2.openStream()));
				
				BufferedWriter mywriter = new BufferedWriter(new FileWriter("C:\\Users\\navam\\OneDrive\\Desktop\\UWindsor\\Sem_1\\ACC\\project\\"+title+".html"));
				
				String line;
				while ((line = myreader.readLine()) != null)
				{
				mywriter.write(line);
				}

				myreader.close();
				mywriter.close();
				}
				catch (IOException e) {}
			
			for(Element link : doc.select("a[href]"))
			{
				String next_link = link.absUrl("href");
				if(visited.contains(next_link)==false)
				{
					
					crawl(level++, next_link, visited);
				}		
			}
			}
		}
	}
	private static Document request(String url, ArrayList<String> v)
	{
		try {		
		Connection con = Jsoup.connect(url);
		Document doc = con.get();		
		//if(con.response().statusCode() == 200)
		//{
			
			System.out.println("link : "+url);
			String title = doc.title();
			System.out.println(doc.title());
			v.add(url);
			return doc;
		//}
		//return null;
			
		}
		catch (IOException e) 
		{
			return null;
		}		
	}
	
	
}
