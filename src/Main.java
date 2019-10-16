import java.util.Arrays;

import com.jyx.sort.Sorts;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,9,10,2,77,1};
//		Sorts.quickSort(nums, 0, nums.length-1);
//		Sorts.shellSort(nums);
		int[] temp = new int[nums.length];
		Sorts.mergeSort(nums, 0, nums.length-1, temp);
		System.out.println(Arrays.toString(nums));
	}

}
