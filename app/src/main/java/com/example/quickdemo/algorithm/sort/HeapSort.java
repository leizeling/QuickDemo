package com.example.quickdemo.algorithm.sort;

import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {
		int[] arr = {2, 5, 21, 88, 13, 7, 3, 20, 1, 65, 19};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void heapSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}

		// 构建堆，从最后一个非叶子结点开始，从下往上，从右往左
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			adjustHeap(arr, i, arr.length);
		}

		for (int i = arr.length - 1; i > 0; i--) {
			swap(arr, 0, i);
			adjustHeap(arr, 0, i);
		}
	}

	/**
	 * @param arr    数组
	 * @param parent 调整的结点
	 * @param length 数组长度
	 */
	private static void adjustHeap(int[] arr, int parent, int length) {
		int temp = arr[parent];
		int childIndex = parent * 2 + 1; // 左子结点
		while (childIndex < length) {
			// 选择左右子结点中较大的
			if (childIndex + 1 < length && arr[childIndex] < arr[childIndex + 1]) {
				childIndex++;
			}

			// 注意：一直都和初始值temp相比
			if (arr[childIndex] > temp) {
				arr[parent] = arr[childIndex];
				parent = childIndex;
				childIndex = parent * 2 + 1;
			} else {
				break;
			}
		}
		arr[parent] = temp;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
