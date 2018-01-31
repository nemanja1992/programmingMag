package org.programmingmag.mag.service.impl;

import java.sql.Date;

import org.programmingmag.mag.model.News;
import org.programmingmag.mag.repository.NewsRepository;
import org.programmingmag.mag.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JpaNewsServiceImpl implements NewsService{
	
	@Autowired
	private NewsRepository newsRepository;
	
	@Override
	public Page<News> findAll(int pageNum) {
		return newsRepository.findAll(
				new PageRequest(pageNum, 8));
				
	}

	@Override
	public News findOne(Long id) {
		return newsRepository.findOne(id);
	}

	@Override
	public void save(News news) {
		newsRepository.save(news);
		
	}

	@Override
	public void remove(Long id) {
		newsRepository.delete(id);
		
	}

	@Override
	public Page<News> findByCategoryId(int pageNum, Long categoryId) {
		return newsRepository.findByCategoryId(categoryId, new PageRequest(pageNum, 8));
	}

	@Override
	public Page<News> pretraga(Date minDate, Date maxDate, int page) {
		// TODO Auto-generated method stub
		return null;
	}

}
