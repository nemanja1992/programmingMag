package org.programmingmag.mag.service;

import java.util.List;

import org.programmingmag.mag.model.Category;

public interface CategoryService {
	List<Category> findAll();
	void save (Category category);
	void remove(Long id);
	Category findOne(Long id);
}
