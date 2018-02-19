package clean.architecture.srp.ex.book;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

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
	
	private final BookRepository bookRepository;

	public Book(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
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

	/**
	 * Generate html string for display 
	 * @return
	 */
	public String printBookHtml() {
		return 
			"<div>" + 
				"<label for=\"title\">Title:</label>" + 
				"<input id=\"title\" value=\"" + getTitle() + "/>" + 
				"<label for=\"author\">Author:</label>" + 
				"<input id=\"author\" value=\"" + getAuthorName() + "/>" +
				"<label for=\"publishDate\">Published Date:</label>" + 
				"<input id=\"publishDate\" value=\"" + getDateString("yyyy-MM-dd") + "/>" + 
				"<label for=\"isbn\">ISBN:</label>" + 
				"<input id=\"isbn\" value=\"" + getIsbn() + "/>" +
			"</div>";
	}
	
	/**
	 * Generate partial xml element for data transfer
	 * @return
	 */
	public String printBookXML() {
		return 
			"<book>" + 
				"<title>" + getTitle() + "</title>" + 
				"<authorName>" + getAuthorName() + "</authorName>" +
				"<publishDate>" + getDateString("yyyy-MM-dd HH:mm:ss.SSSZ") +  "</publishedDate>" + 
				"<isbn>" + getIsbn() + "</isbn>" + 
			"</book>";
	}

	public void save() {
		this.bookRepository.save(this);
	}
}
