package clean.architecture.srp.ex.book;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(schema="SRP", name="Book")
public class Book extends AbstractPersistable<Long>{

	@Column(name="title")
	private String title;
	
	@Column(name="authorName")
	private String authorName;
	
	@Column(name="publishedDate")
	private Date publishDate;
	
	@Column(name="ISBN")
	private String isbn;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getDateString(String format) {
		return new SimpleDateFormat(format).format(getPublishDate());
	}
}
