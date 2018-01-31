package org.programmingmag.mag.service.impl;

import java.util.List;

import org.programmingmag.mag.model.Category;
import org.programmingmag.mag.repository.CategoryRepository;
import org.programmingmag.mag.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JpaCategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public void save(Category category) {
		categoryRepository.save(category);
		
	}

	@Override
	public void remove(Long id) {
		categoryRepository.delete(id);
		
	}

	@Override
	public Category findOne(Long id) {
		return categoryRepository.findOne(id);
	}

}
