package com.lsc;
/**
 * 荷兰国旗问题
 * @author lsc
 * 2018年9月16日 00:58:20
 */
public class TheTwo_First {

	public static int[] partiton(int[] arr, int L, int R, int num) {
		int i = L - 1;
		int j = R + 1;
		int cur = L;
		while(num < j) {
			if(arr[cur] < num) {
				swap(arr, ++i, cur++);
			}else if(arr[cur] > num) {
				swap(arr, --j, cur);
			}else {
				cur++;
			}
		}
		return new int[] { i + 1, j - 1};
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
 	}
	
	public static void main(String[] args) {
		int[] arr = {5, 9, 3, 6, 8, 5, 7, 5, 1, 56};
		int num = 5;
		partiton(arr, 0, arr.length - 1, num);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
