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
@Table(name="LINK")
public class Link {

	@Id
	@GeneratedValue(generator = "LINK_SEQ", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "LINK_SEQ", sequenceName = "LINK_SEQ", allocationSize = 1, initialValue = 1)
	@Column(name = "ID")
	private int id;	

	@Column(name = "URL")
	private String url;

	@Column(name = "TIME")
	private Date time;

	@Column(name = "COLLECTEDLINK")
	private String collectedLink;
	
	
	public Link() {};
	
	public Link(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return id + " " + time + " " + url + " " + collectedLink;
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
	
	public String getCollectedLink() {
		return collectedLink;
	}
	
	public void setCollectedLink(String collectedLink) {
		this.collectedLink = collectedLink;
	}
	
}
