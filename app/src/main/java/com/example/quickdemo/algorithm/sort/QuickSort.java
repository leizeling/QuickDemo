package com.example.quickdemo.algorithm.sort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {2, 5, 21, 88, 13, 7, 3, 20, 1, 65, 19};
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		sort(arr, 0, arr.length - 1);
	}

	private static void sort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}

		int key = arr[low];
		int i = low;
		int j = high;
		while (i < j) {
			while (i < j && key <= arr[j]) {
				j--;
			}
			if (i < j) {
				arr[i] = arr[j];
				i++;
			}

			while (i < j && key > arr[i]) {
				i++;
			}
			if (i < j) {
				arr[j] = arr[i];
				j--;
			}
		}
		arr[i] = key;

		sort(arr, low, i - 1);
		sort(arr, i + 1, high);
	}
}
