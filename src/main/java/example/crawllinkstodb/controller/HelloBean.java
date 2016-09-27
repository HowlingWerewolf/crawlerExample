package example.crawllinkstodb.controller;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import example.crawllinkstodb.model.dao.VisitedPage;
import example.crawllinkstodb.model.dao.VisitedPageService;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

	private static final long serialVersionUID = 1L;

    @EJB
    private VisitedPageService service; 
    
	private String name;

	public String getName() {	   
		return name;
	}

	public void setName(String name) {
		VisitedPage page = new VisitedPage(name);
		page.setTime(new Date());
		service.save(page);	
		this.name = name;
	}

}