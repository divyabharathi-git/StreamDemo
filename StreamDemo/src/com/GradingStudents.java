package com;

import java.util.ArrayList;
import java.util.List;

public class GradingStudents {

	public static void main(String[] args) {
		
		 List<Integer> grades = java.util.Arrays.asList(73,67,38,33);
		
		 List<Integer> newList = new ArrayList<>();

		    grades.stream().forEach(a->{
		    	
		    	int x = 5-(a%5);
		    	if(a < 38 ){
		            newList.add(a);
		        }else if(x == 3) { 
		        	newList.add(a);
		        }else if(x < 3){
		        	int temp = 0;
		        	temp = a+x;
		
		        	newList.add(temp);
		        }
		        
		    });
		    
		    System.out.println(newList);

	}

}
