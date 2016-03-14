package com.himanshu.rest.service;

import com.himanshu.rest.entities.SearchResult;
import com.himanshu.rest.entities.SearchTextInput;

/**
 * 
 * @author Himanshu
 *
 */
public interface TextSearchService {

	SearchResult searchTextCount(SearchTextInput searchTextInput);

	String topXSearch(int number);

}