package example.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupCrawler {
	
	private static Document getDocumentContent(String url) throws IOException{
		return Jsoup.connect(url).get();
	}
	
	public static List<String> getLinksFromPage(String url) {
		Document doc = null;	
		List<String> linkList = new ArrayList<>();
		
		try {
			doc = getDocumentContent(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Elements links = doc.select("a[href]"); // a with href
		for(Element link: links){
			linkList.add(link.attr("abs:href"));
		}
		
		return linkList;
	} 

}
