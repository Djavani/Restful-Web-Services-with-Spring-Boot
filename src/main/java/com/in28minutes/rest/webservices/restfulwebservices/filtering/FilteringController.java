package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	//field1, field2
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		
		return FielterMapping("bean", "field1", "field2");	
		
	}
	
	//field2, field 3
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListOfSomeBean() {		
		return FielterMapping("List", "field2", "field3");
	}

	//Generic Method do filter mapping fields
	public MappingJacksonValue FielterMapping(String beanType, String fieldParam1, String fieldParam2) {	
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fieldParam1, fieldParam2);		
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		if(beanType == "bean" ) {
			SomeBean someBean = new SomeBean("value1", "value2", "value3");
			MappingJacksonValue mapping = new MappingJacksonValue(someBean);
			mapping.setFilters(filters);		
			return mapping;
		}else {
			List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
					new SomeBean("value1-2", "value2-2", "value3-2"));			
			MappingJacksonValue mapping = new MappingJacksonValue(list);
			mapping.setFilters(filters);		
			return mapping;
		}
	}
}
