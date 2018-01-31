package org.programmingmag.mag.web.dto;

import java.sql.Date;

public class CommentDTO {

	
	private Long id;
	private String commentAuthorName;
	private String commentAuthorEmail;
	private String commentTitle;
	private String commentText;
	private Date commentDate;
	private Long newsId;
	private String title;
	private String tagline;
	private String text;
	private Date upDate;
	private Date editDate;
	
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
	public Long getNewsId() {
		return newsId;
	}
	public void setNewsId(Long newsId) {
		this.newsId = newsId;
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
	
	
}
