package example.crawllinkstodb.app;

import java.util.Date;
import java.util.List;

import example.crawllinkstodb.model.SessionHelper;
import example.crawllinkstodb.model.dao.Link;
import example.crawllinkstodb.model.dao.VisitedPage;
import example.jsoup.JSoupCrawler;

public class CrawlLinksToDBApplication {
	
    public static void main(String[] args) {      	
    	String url = "http://stackoverflow.com/";
    	List<String> linkList = JSoupCrawler.getLinksFromPage(url);
    	
    	for (String link : linkList) {
    		Link page = new Link();
    		page.setUrl(url);
    		page.setTime(new Date());
    		page.setCollectedLink(link);
    		
    		System.out.println(page.toString());		
    		
    		try {	
    			// insert 
//    	        SessionHelper.insert(page);
    	        
//    	        // select
//    	        List<Page> list = (List<Page>) SessionHelper.query("FROM Page");
//    	        for(Page e : list) {
//    	        	System.out.println(e.getTime().toString() + " " + e.getUrl() + " " + e.getContent());
//    	        }
//    	        
//    	        // delete
//    	        SessionHelper.delete(list.get(0));
    	        
    		} catch (Exception e) {
    			e.printStackTrace();
    		}		
		}
    	
    	VisitedPage visitedpage = new VisitedPage(url);
    	visitedpage.setTime(new Date());
		
		try {	
			// insert 
//	        SessionHelper.insert(visitedpage);	        
		} catch (Exception e) {
			e.printStackTrace();
		}	

	}  

}
