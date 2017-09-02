import java.util.Arrays;

public class Shuffle2nIntegers {
	
	
	     
	    // Driver Method
	    public static void main(String[] args)
	    {
	        int a[] = { 1, 3, 5, 7, 2, 4, 6, 8 };
	      
	        shufleArray(a, 0, a.length-1);
	         
	        System.out.println(Arrays.toString(a));
	    }

		private static void shufleArray(int[] a, int start, int end) {
			if((end-start)<=1)
				return;
			int mid=(start+end+1)/2;//4,2,2
			int mmid=(start+mid)/2;//2,1,1
			int k=mid;
			for(int i=mmid;i<mid;i++){
				swap(a,i,k++);
			}
			
			shufleArray(a, start, mid-1);
			shufleArray(a, mid, end);
		}

	   
		private static void swap(int[] a, int mmid, int mid) {
			int temp=a[mmid];
			a[mmid]=a[mid];
			a[mid]=temp;
			
		}
}
