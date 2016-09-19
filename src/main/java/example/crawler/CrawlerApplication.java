package example.crawler;

import java.util.List;

public class CrawlerApplication {
	
    public static void main(String[] args) {      	
    	String url = "http://stackoverflow.com/";
    	List<String> linkList = JSoupCrawler.getLinksFromPage(url);
    	
    	for (String link : linkList) {
    	    System.out.println(url + " --- " + link);			
		}
	}  

}
