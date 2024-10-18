package arrayListPkg;

import java.util.Arrays;

public class FindSumFromArray {

	public static void main(String[] args) {
		int arr[]= {5,8,-2,0,-6,-1,12,9,20,-5};
		int arraySize=arr.length;
		int number=4;
		
		if(arrToFindSumOfNumbersFromList(arr,arraySize,number))
		{
			System.out.println("Yes, the numbers resulting to sum="+number+" are present in the list");
		}
		else
			System.out.println("There are no numbers in the list resulting to sum="+number);
	}

	private static boolean arrToFindSumOfNumbersFromList(int[] arr, int arraySize, int number) {
		
		int left=0,right=arraySize-1;
		Arrays.sort(arr);
		
		while(left<right)
		{
			if(arr[left]+arr[right]==number)
				return true;
			else if(arr[left]+arr[right]<number)
				left++;
			else
				right--;
			
		}
		return false;
			

	}

}

