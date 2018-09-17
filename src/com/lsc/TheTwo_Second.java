package com.lsc;

import java.util.Arrays;

/**
 * 快速排序
 * @author Administrator
 *
 */
//--经典快排与随机快排
//时间复杂度O(N*logN)~O(N^2) 空间复杂度 O(logN)~O(N)
public class TheTwo_Second {

	public static void quickSort(int[] arr, int L, int R) {
		if(L < R) {
			swap(arr, L + (int) (Math.random() * (R-L+1)), R);
			int[] p = partiton(arr, L, R);
			quickSort(arr, L, p[0]-1);
			quickSort(arr, p[1]+1, R);
		}
	}
	
	public static int[] partiton(int[] arr, int L, int R) {
		int less = L - 1;
		int more = R;
		while (L < more) {
			if(arr[L] < arr[R]) {
				swap(arr, ++less, L++);
			}else if(arr[L] > arr[R]) {
				swap(arr, --more, L);
			}else {
				L++;
			}
		}
		swap(arr, more, R);
		return new int[] {less + 1, more}; 
	}

	private static void swap(int[] arr, int i, int j) {
		/*arr[i] = arr[i]^arr[j];
		arr[j] = arr[i]^arr[j];
		arr[i] = arr[i]^arr[j];*/
		int num = arr[i];
		arr[i] = arr[j];
		arr[j] = num;
	}
	
	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}
	
	// for test---对数组升序排序
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test---定义一个随机数组
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test---copy出一个一样的数组
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test---对两个一样的数组以不同的方法排序
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			quickSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		/*int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		quickSort(arr);
		printArray(arr);*/

	}
}
