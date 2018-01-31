package org.programmingmag.mag.repository;



import org.programmingmag.mag.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NewsRepository 
	extends JpaRepository<News,Long>{

	Page<News> findByCategoryId(Long categoryId,Pageable pageRequest);
	
//	Page<News> pretraga(
//			@Param("minDate") Date minDate,
//			@Param("maxDate") Date maxDate,
//			Pageable pageRequest);
}
