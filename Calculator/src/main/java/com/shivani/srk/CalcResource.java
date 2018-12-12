package com.shivani.srk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shivani.srk.model.Operation;

@RestController
public class CalcResource {
	
	@Autowired
	private Operation op ;

	
//	@PostMapping("calc/{num1}/{num2}/{operation}")
////	@ResponseBody
//	public double calc(@PathVariable("num1") Integer num1 , @PathVariable("num2") Integer num2, @PathVariable("operation") String operation ) {
//		return op.calc(num1, num2, operation);
//	}
	

	@GetMapping("calc/{operation}/{num}")
//	@ResponseBody
	public String calc(@PathVariable("num") List<String> num, @PathVariable String operation ) {
			
//		
//		Double sum = 0.0;
//		List<Double> numList = num.stream().map( s -> Double.parseDouble(s)).collect(Collectors.toList());
//		for(Double num1 : numList){
//			
//			sum = sum + num1;
//		}
//		return sum;
		
		try {
			
			return String.valueOf(op.calc(num, operation));
		
		} catch (Exception e) {
			
			return "Please pass ony numeric values";
		}
	}
}
