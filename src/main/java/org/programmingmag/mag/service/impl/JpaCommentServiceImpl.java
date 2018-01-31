package org.programmingmag.mag.service.impl;

import java.util.List;

import org.programmingmag.mag.model.Comment;
import org.programmingmag.mag.repository.CommentRepository;
import org.programmingmag.mag.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class JpaCommentServiceImpl implements CommentService {

	
	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public List<Comment> findAll() {
		return commentRepository.findAll();
	}

	@Override
	public void save(Comment comment) {
		commentRepository.save(comment);
		
	}

	@Override
	public void remove(Long id) {
		commentRepository.delete(id);
		
	}

	@Override
	public Comment findOne(Long id) {
		return commentRepository.findOne(id);
	}

//	@Override
//	public Page<Comment> findByNewsId(int pageNum, Long newsId) {
//		return commentRepository.findByNewsId(newsId, new PageRequest(pageNum, 5));
//	}

}
