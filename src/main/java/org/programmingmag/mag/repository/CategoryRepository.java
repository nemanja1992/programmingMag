package org.programmingmag.mag.repository;

import org.programmingmag.mag.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository 
	extends JpaRepository<Category, Long>{

}
