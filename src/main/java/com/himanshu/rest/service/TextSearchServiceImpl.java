/**
 * 
 */
package com.himanshu.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himanshu.rest.entities.SearchResult;
import com.himanshu.rest.entities.SearchTextInput;
import com.himanshu.rest.repository.TextSearchRepository;

/**
 * @author Himanshu
 *
 */
@Service
public class TextSearchServiceImpl implements TextSearchService {
	
	@Autowired
	TextSearchRepository textSearchRepository;
	/* (non-Javadoc)
	 * @see com.himanshu.service.TextSearchService#search(com.himanshu.entities.SearchTextInput)
	 */
	@Override
	public SearchResult searchTextCount(  SearchTextInput searchTextInput ){
		
		System.out.println("search service");
		
		return textSearchRepository.searchTextCount(searchTextInput);
	}
	
	
	/* (non-Javadoc)
	 * @see com.himanshu.service.TextSearchService#top(int)
	 */
	@Override
	public String topXSearch( int number	){
		
		return textSearchRepository.topSearch(number);
	}

}
