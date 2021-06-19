package com.arvind.udemy.Tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImplementation {
	@Autowired
	private sortAlgorithm sortAlgo;
	
	
	public BinarySearchImplementation(sortAlgorithm sortAlgo) {
		super();
		this.sortAlgo = sortAlgo;
	}


	public int binarySearch(int[] arr,int searchNum)
	{
	
		int[] sortedNumbers = sortAlgo.sort(arr);
		System.out.println(sortAlgo);
		return 3;
	}

}
