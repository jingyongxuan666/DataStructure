package com.jyx.sort;

import java.util.Arrays;
import java.util.LinkedList;

public class Sorts {
	/**
	 * ��������
	 * 
	 * @param nums
	 */
	public static void insertSort(int[] nums) {
		if (nums.length == 0) {
			return;
		}
		for (int i = 1; i < nums.length; i++) {
			int leftIndex = i - 1;
			int temp = nums[i];
			while (leftIndex >= 0 && nums[leftIndex] > temp) {
				nums[leftIndex + 1] = nums[leftIndex];
				leftIndex--;
			}
			nums[leftIndex + 1] = temp;
		}
	}

	/**
	 * ð������
	 * 
	 * @param nums
	 */
	public static void bubbleSort(int[] nums) {

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j + 1] < nums[j]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * ѡ������
	 * 
	 * @param nums
	 */
	public static void selectSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			int mIndex = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[mIndex] > nums[j]) {
					mIndex = j;
				}
			}
			if (mIndex != i) {
				int temp = nums[mIndex];
				nums[mIndex] = nums[i];
				nums[i] = temp;
			}
		}
	}

	public static void quickSort(int[] nums, int start, int end) {
		if (start > end) {
			return;
		}

		int low = start;
		int heigh = end;
		int key = nums[start];
		while (low < heigh) {
			while (key <= nums[heigh] && low < heigh) {
				heigh--;
			}

			while (key >= nums[low] && low < heigh) {
				low++;
			}

			if (low < heigh) {
				int temp = nums[low];
				nums[low] = nums[heigh];
				nums[heigh] = temp;
			}
		}
		nums[start] = nums[low];
		nums[low] = key;

		quickSort(nums, start, low - 1);
		quickSort(nums, low + 1, end);

	}

	/**
	 * ϣ������ ˼·���Ȱ�һ���������� �ٶ�ÿ����м򵥲�������
	 * 
	 * @param nums
	 */
	public static void shellSort(int[] nums) {
		for (int gap = nums.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < nums.length; i++) {
				int leftIndex = i - gap;
				int key = nums[i];
				while (leftIndex >= 0 && key < nums[leftIndex]) {
					nums[leftIndex + gap] = nums[leftIndex];
					leftIndex -= gap;
				}
				nums[leftIndex + gap] = key;
			}
			System.out.println(Arrays.toString(nums));
		}
	}

	public static void mergeSort(int[] nums, int left, int right, int[] temp) {

		if (left < right) {
			//����м�������±�
			int mid = (left + right) / 2;
			//�ݹ����
			mergeSort(nums, left, mid, temp);
			mergeSort(nums, mid + 1, right, temp);
			//�ϲ�
			merge(nums, left, mid, right, temp);

		}

	}

	public static void merge(int[] nums, int left, int mid, int right, int[] temp) {
		int i = left;//��벿��������ʼλ��
		int j = mid + 1;//�Ұ벿��������ʼλ��
		int t = 0;
		// 1.��������������ֺϲ���temp����
		while (i <= mid && j <= right) {
			if (nums[i] < nums[j]) {
				temp[t] = nums[i];
				i++;
				t++;
			} else {
				temp[t] = nums[j];
				j++;
				t++;
			}
		}
		// 2.�ϲ�ʣ������鵽temp��
		while (i <= mid) {
			temp[t] = nums[i];
			i++;
			t++;
		}
		while (j <= right) {
			temp[t] = nums[j];
			j++;
			t++;
		}

		// 3.tempת��ԭ����nums�У�ÿ��ֻת��ÿ�ε�left��right�ĳ���
		t = 0;
		int tempLeft = left;
		while (tempLeft <= right) {
			nums[tempLeft] = temp[t];
			tempLeft++;
			t++;
		}

	}
}
