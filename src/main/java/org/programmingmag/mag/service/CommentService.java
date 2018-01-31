package org.programmingmag.mag.service;

import java.util.List;

import org.programmingmag.mag.model.Comment;
import org.springframework.data.domain.Page;

public interface CommentService {
	Comment findOne(Long id);
	List<Comment> findAll();
	void save (Comment comment);
	void remove (Long id);
//	Page<Comment> findByNewsId(int pageNum, Long newsId);
}
