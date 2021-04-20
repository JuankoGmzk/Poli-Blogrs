package co.edu.poli.mongodb.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "collPoliblogrs")
public class News {
	
	@Id
	private String id;
	
	private String author;
	
	private String date;
	
	private String title;
	
	private String body;
				
	public News() {
		
	}

	public News(String author, String date, String title, String body) {
		this.author = author;
		this.date = date;
		this.title = title;
		this.body = body;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}