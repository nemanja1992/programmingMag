package org.programmingmag.mag.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class News {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String title;
	@Column
	private String tagline;
	@Column
	private String text;
	@Column
	private Date upDate;
	@Column
	private Date editDate;
	@ManyToOne(fetch=FetchType.EAGER)
	private Category category;
	@OneToMany(mappedBy="news",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Comment> listOfComments;
	
	
	
	
	public News() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long newsId) {
		this.id = newsId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTagline() {
		return tagline;
	}
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getUpDate() {
		return upDate;
	}
	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}
	public Date getEditDate() {
		return editDate;
	}
	
	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public List<Comment> getListOfComments() {
		return listOfComments;
	}
	public void setListOfComments(List<Comment> listOfComments) {
		this.listOfComments = listOfComments;
	}
	public void  addComment(Comment comment){
		this.listOfComments.add(comment);
		if(!this.equals(comment.getNews())){
			comment.setNews(this);
		}
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
		if(category!=null && !category.getNewsList().contains(this)){
			category.getNewsList().add(this);
		}
	}
	
	
}
