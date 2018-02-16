package univ.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String title;
	private String description;
	private String imagePath;
	private String urlExtern;
	
	public Product(String title, String description, String imagePath, String urlExtern) {
		super();
		this.title = title;
		this.description = description;
		this.imagePath = imagePath;
		this.urlExtern = urlExtern;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getUrlExtern() {
		return urlExtern;
	}
	public void setUrlExtern(String urlExtern) {
		this.urlExtern = urlExtern;
	}
	
}

	
