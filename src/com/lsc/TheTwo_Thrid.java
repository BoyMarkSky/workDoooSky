package com.lsc;

public class TheTwo_Thrid {
	
	public static void main(String[] args) {
		int arr[] = {-2, 6};
		swap(arr, 0, 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println(1/2);
	}
	private static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i]^arr[j];
		arr[j] = arr[i]^arr[j];
		arr[i] = arr[i]^arr[j];
	}
}
