package org.programmingmag.mag.web.controller;





import org.programmingmag.mag.model.News;
import org.programmingmag.mag.service.CommentService;
import org.programmingmag.mag.service.NewsService;
import org.programmingmag.mag.support.CommentToCommentDTO;
import org.programmingmag.mag.support.NewsDTOToNews;
import org.programmingmag.mag.support.NewsToNewsDTO;
import org.programmingmag.mag.web.dto.NewsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/news")
public class ApiNewsController {
	
	@Autowired
	private NewsService newsService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private NewsToNewsDTO toDTO;
	@Autowired
	private NewsDTOToNews toNews;
	@Autowired
	private CommentToCommentDTO toCommentDTO;
	
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<NewsDTO> get(
			@PathVariable Long id){
		News news=newsService.findOne(id);
		
		if(news==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toDTO.convert(news),
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}")
	public ResponseEntity<NewsDTO> edit(
			@PathVariable Long id,
			@RequestBody NewsDTO changed){
		if(!id.equals(changed.getCategoryId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		News news=toNews.convert(changed);
		newsService.save(news);
		
		return new ResponseEntity<>(toDTO.convert(news),
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<NewsDTO> add(
			@RequestBody NewsDTO newNews){
		News news= toNews.convert(newNews);
		newsService.save(news);
		return new ResponseEntity<>(toDTO.convert(news),
				HttpStatus.CREATED);
	}
	@RequestMapping(method=RequestMethod.DELETE,
			value="/{id}")
	public ResponseEntity<NewsDTO> delete(@PathVariable Long id){
		newsService.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
//	@RequestMapping(value="/{newsId}/comment")
//	public ResponseEntity<List<CommentDTO>> commentsNews(
//			@PathVariable Long newsId,
//			@RequestParam(defaultValue="0") int pageNum){
//		Page<Comment> comments= commentService.findByNewsId(pageNum, newsId);
//		
//		HttpHeaders header = new HttpHeaders();
//		header.add("totalPages", Integer.toString(comments.getTotalPages()));
//		return new ResponseEntity<>(
//				toCommentDTO.convert(comments.getContent()),
//				header,
//				HttpStatus.OK);
//	}
		
	
}
