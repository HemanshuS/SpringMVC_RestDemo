/**
 * 
 */
package com.himanshu.rest.entities;

import java.util.List;
import java.util.Map;

/**
 * Entity holding the search result;
 * I have put in list just for sake of look in JSON format. 
 * Could have been done teh other way!
 * @author Himanshu
 *
 */
public class SearchResult {
	
	
	
	private List<Map<String,Integer>> counts;

	public List<Map<String, Integer>> getCounts() {
		return counts;
	}

	public void setCounts(List<Map<String, Integer>> counts) {
		this.counts = counts;
	}
}
