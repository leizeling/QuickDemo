package com.example.quickdemo.algorithm.sort;

import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
		int[] arr = {2, 5, 21, 88, 13, 7, 3, 20, 1, 65, 19};
		shellSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void shellSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}

		int gap = arr.length / 2;
		while (gap >= 1) {
			for (int i = 0; i < gap; i++) { // 分的组数
				for (int j = i + gap; j < arr.length; j += gap) {
					for (int k = j; k > i; k -= gap) {
						if (arr[k] < arr[k - gap]) {
							int temp = arr[k];
							arr[k] = arr[k - gap];
							arr[k - gap] = temp;
						} else {
							break;
						}
					}
				}
			}
			gap /= 2;
		}
	}
}
