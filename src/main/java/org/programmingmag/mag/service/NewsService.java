package org.programmingmag.mag.service;

import java.sql.Date;

import org.programmingmag.mag.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

public interface NewsService {
	Page<News> findAll(int pageNum);
	News findOne(Long id);
	void save (News news);
	void remove(Long id);
	Page<News> findByCategoryId(int pageNum, Long categoryId);
	Page<News> pretraga(
			@Param("minDate") Date minDate,
			@Param("maxDate") Date maxDate,
			int page);
}
