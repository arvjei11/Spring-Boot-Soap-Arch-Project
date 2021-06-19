package com.arvind.udemy.Tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TutorialApplication {

	public static void main(String[] args) {
		
		//BinarySearchImplementation binarySearch = new BinarySearchImplementation(new BubbleSort());
		
		ApplicationContext applicationContext = SpringApplication.run(TutorialApplication.class, args);
		BinarySearchImplementation binarySearch = applicationContext.getBean(BinarySearchImplementation.class);
		int res = binarySearch.binarySearch(new int[] {124,4,5},3);
		System.out.println(res);
	}

}
