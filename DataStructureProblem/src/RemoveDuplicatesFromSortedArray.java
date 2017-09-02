import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		Integer arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5};
		System.out.println(Arrays.deepToString(removeDuplicates(arr)));
		

	}

	private static Integer[] removeDuplicates(Integer[] arr) {
		int j=0;
		for(int i=0;i<arr.length-1;i++){
			if(arr[i]!=arr[i+1]){
				arr[j++]=arr[i];
			}
		}
		arr[j++]=arr[arr.length-1];
		return Arrays.copyOfRange(arr, 0, j);
	}

}
