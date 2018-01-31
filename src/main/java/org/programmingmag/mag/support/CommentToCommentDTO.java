package org.programmingmag.mag.support;

import java.util.ArrayList;
import java.util.List;

import org.programmingmag.mag.model.Comment;
import org.programmingmag.mag.web.dto.CommentDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommentToCommentDTO 
	implements Converter<Comment, CommentDTO>{

	@Override
	public CommentDTO convert(Comment c) {
		CommentDTO dto=new CommentDTO();
		dto.setId(c.getId());
		dto.setCommentAuthorName(c.getCommentAuthorName());
		dto.setCommentAuthorEmail(c.getCommentAuthorEmail());
		dto.setCommentTitle(c.getCommentTitle());
		dto.setCommentText(c.getCommentText());
		dto.setCommentDate(c.getCommentDate());
		dto.setNewsId(c.getNews().getId());
		dto.setTitle(c.getNews().getTitle());
		dto.setTagline(c.getNews().getTagline());
		dto.setText(c.getNews().getText());
		dto.setUpDate(c.getNews().getUpDate());
		dto.setEditDate(c.getNews().getEditDate());
		
		return dto;
	}
	
	public List<CommentDTO> convert(List<Comment> comment){
		List<CommentDTO> ret= new ArrayList<>();
		
		for(Comment c: comment){
			ret.add(convert(c));
		}
		
		return ret;
	}
	

	
}
