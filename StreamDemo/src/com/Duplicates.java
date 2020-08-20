package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Duplicates {

	public static void main(String[] args) {
		
		//Java 7
		List<Integer> list = Arrays.asList(1,2,3,1,1,2);
		
		System.out.println("The original list is "+ list);
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<list.size();i++) {
			
			for(int j=i+1;j<list.size();j++) {
				
				if(map.containsKey(list.get(i))) {
					
					if(list.get(i) == list.get(j)) {
						map.put(list.get(i),map.get(list.get(i))+1);
					}
					
				}else {
					map.put(list.get(i),1);
				}
			}
		}
			
			System.out.println("Non Repeating elements are ");
		
			for(Map.Entry<Integer, Integer> entry : map.entrySet()){
				if(entry.getValue() == 1) {
					System.out.println(entry.getKey() + " ");
					
				}
				
			}
			
			System.out.println("Repeating elements are ");
			
			for(Map.Entry<Integer, Integer> entry : map.entrySet()){
				if(entry.getValue() > 1) {
					System.out.println(entry.getKey() + " ");
					
				}
				
			}
			
			//Java 8
			
			System.out.println("List after duplicates removed ");
			
			
			list.stream().distinct().forEach(e->System.out.println(e));
			
			
			
			System.out.println("Non Repeating elements are ");
			
			 map.entrySet().stream()
			 	           .filter(e-> e.getValue() == 1)
						   .forEach(f-> System.out.println(f.getKey()));
			 
			long count1 =  map.entrySet().stream()
	           .filter(e-> e.getValue() == 1)
			   .count();
			System.out.println("count of Non Repeating elements is " + count1);
			
			System.out.println("Repeating elements are ");
			
			
			
			map.entrySet().stream()
			 	           .filter(e-> e.getValue() > 1)
						   .forEach(f-> System.out.println(f.getKey()));
			
			map.entrySet().stream()
	           .filter(e-> e.getValue() > 1)
			   .forEach(f-> System.out.println(f.getKey()));
			
			
			long count2 = map.entrySet().stream()
	           .filter(e-> e.getValue() > 1)
			   .count();
			
			System.out.println("count of Repeating elements is " + count2);
			
			
			Map<Integer, Long> newMap = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			 
			System.out.println(newMap);
			
			List<String> colors = Arrays.asList("green","blue","green","red","blue");
			
			Map<String,Long> colorsMap = colors.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			
			colorsMap.keySet().stream().forEach(a->{
				
				List<String> newList = new ArrayList<>();
				
				newList.add(a);
				
			});
			
			System.out.println(colorsMap);
		 
								
	}

}
