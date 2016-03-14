package com.himanshu.rest.repository;

import com.himanshu.rest.entities.SearchResult;
import com.himanshu.rest.entities.SearchTextInput;

/**
 * Some part of it can be moved to service or controller layer; but keeping it here for simplicity.
 * 
 * @author Himanshu
 *
 */
public interface TextSearchRepository {

	SearchResult searchTextCount(SearchTextInput searchTextInput);

	String topSearch(int number);

}