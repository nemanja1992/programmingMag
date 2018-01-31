package org.programmingmag.mag.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Comment {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String commentAuthorName;
	@Column
	private String commentAuthorEmail;
	@Column
	private String commentTitle;
	@Column
	private String commentText;
	@Column
	private Date commentDate;
	@ManyToOne(fetch=FetchType.EAGER)
	private News news;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long commentId) {
		this.id = commentId;
	}
	public String getCommentAuthorName() {
		return commentAuthorName;
	}
	public void setCommentAuthorName(String commentAuthorName) {
		this.commentAuthorName = commentAuthorName;
	}
	public String getCommentAuthorEmail() {
		return commentAuthorEmail;
	}
	public void setCommentAuthorEmail(String commentAuthorEmail) {
		this.commentAuthorEmail = commentAuthorEmail;
	}
	public String getCommentTitle() {
		return commentTitle;
	}
	public void setCommentTitle(String commentTitle) {
		this.commentTitle = commentTitle;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
		if(news!=null && !news.getListOfComments().contains(this)){
			news.getListOfComments().add(this);
		}
	}
	
	
	
}
