package com.shivani.srk.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class Operation {
	
	public Double calc(List<String> num, String operation) {

		Double sum = 0.0;
		Double product = 1.0;
		Double quotient = 1.0;
		Double ans = 0.0;
		
		List<Double> numList = num.stream().map( s -> Double.parseDouble(s)).collect(Collectors.toList());
		
		if("multiply".equals(operation)) {
			
			for(Double num1 : numList){
				
				product = product*num1;
			}
			return product;
		
		}else if("divide".equals(operation)) {
			
			for(Double num1 : numList){
				
				if(numList.indexOf(num1)==0) {
				    
					quotient = num1/quotient;
				   
				}else {
				    	
					quotient = quotient/num1;
				    
				}
			}
			return quotient;
		}else if("add".equals(operation)) {
			
			for(Double num1 : numList){
				
				sum = sum + num1;
			}
			return sum;
		
		}else if("subtract".equals(operation)) {
			
			for(Double num1 : numList){
				
				if(numList.indexOf(num1)==0) {
				    
					ans = num1 - ans;
				   
				}else {
				    	
					ans = ans-num1;
				}

			}
			return ans;
		
		}else {
			
			return 0.0;
			
		}		
	}

}
