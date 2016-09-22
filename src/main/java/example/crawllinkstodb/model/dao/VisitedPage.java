package example.crawllinkstodb.model.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="VISITEDPAGE")
public class VisitedPage {

	@Id
	@GeneratedValue(generator = "VISITEDPAGE_SEQ", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "VISITEDPAGE_SEQ", sequenceName = "VISITEDPAGE_SEQ")
	@Column(name = "ID")
	private int id;	

	@Column(name = "URL")
	private String url;

	@Column(name = "TIME")
	private Date time;
	
	
	public VisitedPage() {};
	
	public VisitedPage(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return id + " " + time + " " + url;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}
	
}
