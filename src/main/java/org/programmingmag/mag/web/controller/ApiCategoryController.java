package org.programmingmag.mag.web.controller;

import java.util.List;

import org.programmingmag.mag.model.Category;
import org.programmingmag.mag.model.News;
import org.programmingmag.mag.service.CategoryService;
import org.programmingmag.mag.service.NewsService;
import org.programmingmag.mag.support.CategoryToCategoryDTO;
import org.programmingmag.mag.support.NewsToNewsDTO;
import org.programmingmag.mag.web.dto.CategoryDTO;
import org.programmingmag.mag.web.dto.NewsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/category")
public class ApiCategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private CategoryToCategoryDTO toDTO;
	@Autowired
	private NewsToNewsDTO toNewsDTO;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<CategoryDTO> get(
			@PathVariable Long id){
		Category category= categoryService.findOne(id);
		if(category== null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<> (
				toDTO.convert(category),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/{categoryId}/news")
	public ResponseEntity<List<NewsDTO>> newsCategories(
			@PathVariable Long categoryId,
			@RequestParam(defaultValue="0") int pageNum){
		Page<News> news= newsService.findByCategoryId(pageNum, categoryId);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(news.getTotalPages()));
		return new ResponseEntity<>(
				toNewsDTO.convert(news.getContent()),
				headers,
				HttpStatus.OK);
	}
}
