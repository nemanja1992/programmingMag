package org.programmingmag.mag.support;

import org.programmingmag.mag.model.Comment;
import org.programmingmag.mag.service.CommentService;
import org.programmingmag.mag.service.NewsService;
import org.programmingmag.mag.web.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class CommentDTOToComment 
	implements Converter<CommentDTO, Comment>{

	@Autowired
	private CommentService commentService;
	@Autowired
	private NewsService newsService;
	
	@Override
	public Comment convert(CommentDTO source) {
		Comment comment;
		if(source.getId()==null){
			comment=new Comment();
			comment.setNews(
					newsService.findOne(
							source.getNewsId()));
		}else{
			comment=commentService.findOne(source.getId());
		}
		comment.setCommentAuthorName(source.getCommentAuthorName());
		comment.setCommentAuthorEmail(source.getCommentAuthorEmail());
		comment.setCommentTitle(source.getCommentTitle());
		comment.setCommentText(source.getCommentText());
		comment.setCommentDate(source.getCommentDate());
		
		return comment;
	}
	
}
