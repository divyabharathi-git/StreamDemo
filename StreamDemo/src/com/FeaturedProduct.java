
package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FeaturedProduct {

	public static void main(String[] args) {
		
		System.out.println("*************hacker rank****************");
		
		String productName = "";
		
		//List<String> products = Arrays.asList("greenPants","blue","greenPants","red","blue","yellowShirt","yellowShirt","yellowShirt","whitePant");
		//List<String> products = Arrays.asList("greenPants","blue","greenPants","greenPants","red","blue","yellowPants","yellowPants","yellowPants","whitePant");
		//List<String> products = Arrays.asList("greenPants","blue","greenPants","greenPants","red","blue","yellowPants","yellowPants","yellowPants","whitePant","yellowShirt","yellowShirt","yellowShirt");
		List<String> products = Arrays.asList("greenPants","blue","greenPants"
											,"greenPants","red","blue"
											,"yellowPants","yellowPants","yellowPants"
											,"whitePant","whitePant","whitePant","whitePant"
											,"yellowShirt","yellowShirt","yellowShirt");
											
		
		List<String> productList = new ArrayList<>();
		List<Long> countList = new ArrayList<>();
		
		List<String> keylist = new ArrayList<>();
		List<Long> valuelist = new ArrayList<>();
		
		List<String> maxlist =  new ArrayList<>();
		
		
		Map<String,Long> productsMap = products.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(productsMap);
		
		productsMap.entrySet().stream().forEach(a->{
			
			String key = a.getKey();
			Long value = a.getValue();
			
			keylist.add(key);
			valuelist.add(value);
			
		});
		
		Long max = Collections.max(valuelist);
		
		for(Entry<String, Long> entry : productsMap.entrySet()){
			if(entry.getValue() == max) {
				
				String str = entry.getKey();
				maxlist.add(str);
				
			}
			
		}
		
		
		if(maxlist != null ) {
			if(maxlist.size() > 1) {
				
				productsMap.entrySet().stream().filter(e-> e.getValue() > 1)
				   .forEach(f->{
					   Long c = f.getValue();
					   countList.add(c);
					   
				   });
				
				
				Map<Long, Long> countListDetails = countList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
				
							
				countListDetails.entrySet().stream().filter(e-> e.getValue() > 1).forEach(a->{
					long key = a.getKey();
					
					productsMap.entrySet().stream().filter(e-> e.getValue() == key).forEach(x->{
						String str = x.getKey();
						   productList.add(str);
					});
					
					});
				
						
				List<String> sortedList = productList.stream().sorted(Comparator.reverseOrder())
	                    .collect(Collectors.toList());
				 
				if(sortedList != null) {
					productName = sortedList.get(0);
				}
				
				System.out.println("The featured product is = " + productName);
				
				
			}else if(maxlist.size() == 1){
				
				for(Entry<String, Long> entry : productsMap.entrySet()){
					if(entry.getValue() == max) {
						
						productName = entry.getKey();
						System.out.println("The featured product is = " + productName);
					}
					
				}
			}
		}
		

	}

}
