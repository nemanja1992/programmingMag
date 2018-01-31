package org.programmingmag.mag.support;

import java.util.ArrayList;
import java.util.List;

import org.programmingmag.mag.model.Category;
import org.programmingmag.mag.web.dto.CategoryDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryDTO 
	implements Converter<Category, CategoryDTO>{

	@Override
	public CategoryDTO convert(Category c) {
		CategoryDTO dto=new CategoryDTO();
		dto.setId(c.getId());
		dto.setCategoryName(c.getCategoryName());
		return dto;
	}
	
	public List<CategoryDTO> convert(List<Category> categories){
		List<CategoryDTO> ret=new ArrayList<>();
		
		for(Category c: categories){
			ret.add(convert(c));
		}
		return ret;
	}

}
