package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class test {

	
	public static void main(String[] args) throws IOException {
		
		String fileName = "D:/foo.txt";
		Map<String, Integer> result = countWords(fileName);
		List<Entry<String, Integer>> list = sortByValue(result);

		for (Map.Entry<String, Integer> entry : list)
		{
		    System.out.println(entry.getValue() + " " + entry.getKey());
		}
	}
	
	private static Map<String, Integer> countWords(String fileName) throws IOException {
		
		String fileLine;
		
		FileReader f = new FileReader(fileName);
		BufferedReader bf = new BufferedReader(f);
		Map<String, Integer> wordCount = new HashMap<String, Integer>();
		while((fileLine = bf.readLine()) != null){
			String[] splitStr = fileLine.split(" ");
			for(String s: splitStr) {
				Integer val = wordCount.get(s);
				if(val == null)
					wordCount.put(s, 1);
				else
					wordCount.put(s,val+1);
			}
		}
		bf.close();
		return wordCount;
	}
	
	private static List<Entry<String, Integer>> sortByValue(Map<String, Integer> wordMap){
        
        Set<Entry<String, Integer>> set = wordMap.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        return list;
    }
}