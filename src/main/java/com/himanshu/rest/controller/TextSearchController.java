package com.himanshu.rest.controller;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.himanshu.rest.entities.SearchResult;
import com.himanshu.rest.entities.SearchTextInput;
import com.himanshu.rest.service.TextSearchService;

/**
 * This is the main Controller class for handing text search.
 * @author Himanshu
 *
 */
@Controller
public class TextSearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(TextSearchController.class);
	
	@Autowired
	TextSearchService textSearchService;
	
	@RequestMapping(value="/search", method=RequestMethod.POST,consumes="application/json",produces="application/json" )
	public @ResponseBody SearchResult search( @RequestBody SearchTextInput searchTextInput){
		
		logger.info("search() called from:"+this.getClass().getSimpleName());
		return textSearchService.searchTextCount(searchTextInput);
	}
	
	@RequestMapping(value="/top/{number}", method=RequestMethod.GET,produces="text/csv")
	public @ResponseBody String top(@PathVariable("number")int number	){
		
		logger.info("top() called from:"+this.getClass().getSimpleName());
		
		return textSearchService.topXSearch(number);
	}
	
	@ExceptionHandler(FileNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "File might have been moved!")
	public void handleSearchException(FileNotFoundException ex){
		 logger.info("Handlng FileNotFoundException - Catching: "
			        + ex.getClass().getSimpleName());
	}

}
