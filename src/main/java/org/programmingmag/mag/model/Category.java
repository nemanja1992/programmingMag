package org.programmingmag.mag.model;


import java.util.List;








import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Category {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String categoryName;
	@OneToMany(mappedBy="category",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<News> newsList;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long categoryId) {
		this.id = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<News> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	public void addNews(News news){
		this.newsList.add(news);
		
		if(!this.equals(news.getCategory())){
			news.setCategory(this);
		}
	}
	
	
}
