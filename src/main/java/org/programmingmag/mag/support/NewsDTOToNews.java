package org.programmingmag.mag.support;

import org.programmingmag.mag.model.News;
import org.programmingmag.mag.service.CategoryService;
import org.programmingmag.mag.service.NewsService;
import org.programmingmag.mag.web.dto.NewsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NewsDTOToNews 
	implements Converter<NewsDTO, News>{
	
	@Autowired
	private NewsService newsService;
	@Autowired
	private CategoryService categoryService;
	
	@Override
	public News convert(NewsDTO source) {
		News news;
		if(source.getId()==null){
			news=new News();
			news.setCategory(
					categoryService.findOne(
							source.getCategoryId()));
		}else{
			news=newsService.findOne(source.getId());
		}
		news.setTitle(source.getTitle());
		news.setTagline(source.getTagline());
		news.setText(source.getText());
		news.setUpDate(source.getUpDate());
		news.setEditDate(source.getEditDate());
		
		return news;
	}

}
