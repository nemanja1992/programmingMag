package org.programmingmag.mag.support;



import java.util.ArrayList;
import java.util.List;

import org.programmingmag.mag.model.News;
import org.programmingmag.mag.web.dto.NewsDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class NewsToNewsDTO 
	implements Converter<News, NewsDTO>{

	@Override
	public NewsDTO convert(News n) {
		NewsDTO dto=new NewsDTO();
		dto.setId(n.getId());
		dto.setTitle(n.getTitle());
		dto.setTagline(n.getTagline());
		dto.setText(n.getText());
		dto.setUpDate(n.getUpDate());
		dto.setEditDate(n.getEditDate());
		dto.setCategoryId(n.getCategory().getId());
		dto.setCategoryName(n.getCategory().getCategoryName());
		
		return dto;
	}
	
	public List<NewsDTO> convert(List<News> news){
		List<NewsDTO> ret= new ArrayList<>();
		
		for(News n: news){
			ret.add(convert(n));
		}
		return ret;
	}

}
