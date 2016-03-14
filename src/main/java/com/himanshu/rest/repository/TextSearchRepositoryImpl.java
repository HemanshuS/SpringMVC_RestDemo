/**
 * 
 */
package com.himanshu.rest.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.himanshu.rest.entities.SearchResult;
import com.himanshu.rest.entities.SearchTextInput;
import com.himanshu.rest.utils.SortUtil;

@Repository
public class TextSearchRepositoryImpl implements TextSearchRepository {
	
	
	
	/* (non-Javadoc)
	 * @see com.himanshu.repository.TextSearchRepository#search(com.himanshu.entities.SearchTextInput)
	 */
	@Override
	public SearchResult searchTextCount(  SearchTextInput searchTextInput ){
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("sampleText.txt").getFile());
		Map<String, Integer> countMap = new HashMap<>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String [] str = line.split("[ |,|;|-|:]+");
			
			for (String string : str) {
				for (String text : searchTextInput.getSearchText())   {
					if (string.contains(text))
					{
						if (countMap.containsKey(text)) {
							countMap.put(text, countMap.get(text)+1);
							
						} else {
							countMap.put(text, 1);
						}
					}
				}
			}
		}
		scanner.close();
		SearchResult result = new SearchResult();
		List<Map<String,Integer>> list = new ArrayList<>();
		list.add(countMap);
		result.setCounts(list);
	return result;	
	}
	
	/* (non-Javadoc)
	 * @see com.himanshu.repository.TextSearchRepository#top(int)
	 */
	@Override
	public String topSearch( int number	){
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("sampleText.txt").getFile());
		Map<String, Integer> countMap = new HashMap<>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String [] str = line.split("[ |,|;|-|:]+");
			
			for (String word : str) {
				if (countMap.containsKey(word)) {
					countMap.put(word, countMap.get(word) + 1);

				} else {
					countMap.put(word, 1);
				}
			}
		}
		scanner.close();
		
		List<Entry<String, Integer>> sortedList = SortUtil.sortByValue(countMap);
		StringBuilder csvText = new StringBuilder();
		for (Iterator<Entry<String, Integer>> iterator = sortedList.iterator(); iterator.hasNext()&& number >0 ;number--) {
			Entry<String, Integer> entry = (Entry<String, Integer>) iterator.next();
			
			csvText.append(entry.getKey());
			csvText.append('|');
			csvText.append(entry.getValue());
			csvText.append('\n');
		}
		
		return csvText.toString();
		
	}
}
