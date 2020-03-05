import java.util.Scanner;
import java.util.Arrays; 

public class MergeArrays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter data for sorted array 1: ");
		String input = sc.nextLine();
		int[] arr1 = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray(); 
		
		System.out.print("Please enter data for sorted array 2: ");
		input = sc.nextLine();
		int[] arr2 = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray(); 

		// sort arrays 
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		// merge arr1 and arr2
		int[] result = merge(arr1, arr2);

		// print array
		System.out.print("\nArray 1: " + Arrays.toString(arr1) + "\n");
		System.out.print("Array 2: " + Arrays.toString(arr2) + "\n");
		System.out.println("Sorted Merged Array: " + Arrays.toString(result) + "\n");
	}

	public static int[] merge(int[] a, int[] b) {
		int[] mergeArray = new int[a.length + b.length];

		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
            	mergeArray[k] = a[i];
            	i++;
        	} else {
            	mergeArray[k] = b[j];
            	j++;
        	}
        	k++;
		}
    	
    	while (i < a.length) {
        	mergeArray[k] = a[i];
        	i++;
        	k++;
    	}
    	while (j < b.length) {
        	mergeArray[k] = b[j];
        	j++;
        	k++;
    	}
    	return mergeArray;
	}
}
