package com.example.quickdemo.algorithm.sort;

import java.util.Arrays;

public class RadixSort {
	public static void main(String[] args) {
		int[] arr = {2, 5, 21, 88, 13, 7, 3, 20, 1, 65, 19};
		radixSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void radixSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}

		// 找到最大值位数
		int bitCount = maxBit(arr);
		int length = arr.length;
		int[] temp = new int[length];
		int[] count = new int[10];
		int radix = 1;
		for (int bit = 1; bit <= bitCount; bit++) {
			// 初始化临时数组
			Arrays.fill(count, 0);

			// 计算元素归属于哪个桶
			for (int i = 0; i < length; i++) {
				int index = (arr[i] / radix) % 10;
				count[index]++;
			}

			// 将count的中值从第一个桶到当前桶的总数和
			for (int i = 1; i < 10; i++) {
				count[i] += count[i - 1];
			}

			// 将原始数组元素根据当前位的排序结果放到临时数组中,从后往前面，因为后面的值大
			for (int i = length - 1; i >= 0; i--) {
				int index = (arr[i] / radix) % 10;
				count[index]--;
				temp[count[index]] = arr[i];
			}

			// 将临时数组的元素拷贝回原始数组
			for (int i = 0; i < length; i++) {
				arr[i] = temp[i];
			}

			radix *= 10;
		}
	}

	private static int maxBit(int[] arr) {
		int length = arr.length;
		int maxValue = arr[0];
		for (int i = 1; i < length; i++) {
			if (maxValue < arr[i]) {
				maxValue = arr[i];
			}
		}

		int indexCount = 1;
		while (maxValue > 10) {
			maxValue /= 10;
			indexCount++;
		}

		return indexCount;
	}

}
