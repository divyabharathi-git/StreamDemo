package com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Arrays {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		
		int sum = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            sum = sum + arr[i];
        }
        
        
        
        //sum = iplist.stream().mapToInt(Integer::intValue).sum();
        
        System.out.println("sum ==>" + sum);

        for(int i=0;i<arr.length;i++){
            int listsum = sum - arr[i];
            list.add(listsum);
        }
        System.out.println("list ==>" + list);
        
       Integer min =  list.stream().min(Comparator.comparing(Integer::valueOf)).get();
       Integer max =  list.stream().max(Comparator.comparing(Integer::valueOf)).get();
       System.out.println("max ==>" + max);
       System.out.println("min ==>" + min);

	}


}
