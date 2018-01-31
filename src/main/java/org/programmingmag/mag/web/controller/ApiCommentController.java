package org.programmingmag.mag.web.controller;

import org.programmingmag.mag.model.Comment;
import org.programmingmag.mag.service.CommentService;
import org.programmingmag.mag.support.CommentToCommentDTO;
import org.programmingmag.mag.web.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/comment")
public class ApiCommentController {
	
	@Autowired 
	private CommentService commentService;
	@Autowired
	private CommentToCommentDTO toDTO;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<CommentDTO> get(
			@PathVariable Long id){
		Comment comment= commentService.findOne(id);
		
		if(comment == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toDTO.convert(comment),
				HttpStatus.OK);
	}
}
