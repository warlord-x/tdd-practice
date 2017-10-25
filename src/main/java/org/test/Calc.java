package org.test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Calc {

	
	public int addInt(String numbers) throws Exception {
		if(numbers==null||numbers=="")
			return 0;
		
		numbers = this.format(numbers, "\n");
		String[] splitNums = numbers.split(",");
		
		


        StringBuilder s = Arrays.stream(splitNums)
                .mapToInt(Integer::valueOf)
                .filter((t) -> t < 0)
                .collect(() -> new StringBuilder("Negative not allowed:"),
                        StringBuilder::append,
                        StringBuilder::append);
        //.forEach((t)->exceptionMessage.concat("Negative not allowed:"+t));
		
		if(!s.toString().equals("Negative not allowed:"))
			throw new Exception(s.toString());
		
		//splitNums = Arrays.stream(splitNums).peek(t->t.split("\n")).collect(Collectors.toList()).toArray();
		
		switch(splitNums.length) {
		case 1:
				return Integer.valueOf(splitNums[0]);
			
		case 2: return Integer.valueOf(splitNums[0])+Integer.valueOf(splitNums[1]);
		default:
			
			return Arrays.stream(splitNums)
					.mapToInt(Integer::valueOf)
					.sum();
		}
		
		
	}
	
	private String format(String numbers, String separator) {
		return numbers.replace(separator, ",");
			
	}
}