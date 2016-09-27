package example.crawllinkstodb.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import example.crawllinkstodb.model.dao.Link;
import example.crawllinkstodb.model.dao.LinkService;
import example.crawllinkstodb.model.dao.VisitedPage;
import example.crawllinkstodb.model.dao.VisitedPageService;
import example.jsoup.JSoupCrawler;

@ManagedBean
@SessionScoped
public class CrawlerBean implements Serializable {

	private static final long serialVersionUID = 1L;

    @EJB
    private VisitedPageService visitedPageService; 

    @EJB
    private LinkService linkService; 
    
	private String url;
	private String crawlResult;

	public String getUrl() {	   
		return url;
	}

	public void setUrl(String url) {
		VisitedPage page = new VisitedPage(url);
		page.setTime(new Date());
		visitedPageService.save(page);	
		this.url = url;
	}

	public String getCrawlResult() {   
		crawl();
		List<Link> linkList = linkService.list();
		StringBuilder sb = new StringBuilder();
		for (Link link : linkList) {
			sb.append(link.getCollectedLink() + " \n");
		}
		setCrawlResult(sb.toString());
		return crawlResult;
	}

	public void setCrawlResult(String crawlResult) {
		this.crawlResult = crawlResult;
	}
	
	private void crawl() {
    	List<String> linkList = JSoupCrawler.getLinksFromPage(url);
    	for (String linkElement : linkList) {
    		Link link = new Link();
    		link.setUrl(url);
    		link.setTime(new Date());
    		link.setCollectedLink(linkElement);	
    		linkService.save(link);	
		}		
	}

}