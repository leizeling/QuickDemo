package com.example.quickdemo.algorithm.sort;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {2, 5, 21, 88, 13, 7, 3, 20, 1, 65, 19};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		sort(arr, 0, arr.length - 1);
	}

	private static void sort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}

		int mid = low + (high - low) / 2;
		sort(arr, low, mid);
		sort(arr, mid + 1, high);
		sortTwoArray(arr, low, mid, high);
	}

	private static void sortTwoArray(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int firstLow = low;
		int firstHigh = mid;
		int secondLow = mid + 1;
		int secondHigh = high;
		int index = 0;
		while (firstLow <= firstHigh && secondLow <= secondHigh) {
			if (arr[firstLow] < arr[secondLow]) {
				temp[index] = arr[firstLow];
				index++;
				firstLow++;
			} else {
				temp[index] = arr[secondLow];
				index++;
				secondLow++;
			}
		}
		while (firstLow <= firstHigh) {
			temp[index] = arr[firstLow];
			index++;
			firstLow++;
		}

		while (secondLow <= secondHigh) {
			temp[index] = arr[secondLow];
			index++;
			secondLow++;
		}

		for (int i = 0; i < index; i++) {
			arr[low + i] = temp[i];
		}
	}
}
