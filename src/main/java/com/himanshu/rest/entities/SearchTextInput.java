/**
 * 
 */
package com.himanshu.rest.entities;

import java.util.List;

/**
 * It is a wrapper for REST input for search.
 * @author Himanshu
 *
 */
public class SearchTextInput {
	
	
	private List<String> searchText;

	public List<String> getSearchText() {
		return searchText;
	}

	public void setSearchText(List<String> searchText) {
		this.searchText = searchText;
	}

	
	
}
