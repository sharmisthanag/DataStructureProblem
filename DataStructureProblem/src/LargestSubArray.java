

public class LargestSubArray
{
	void maxLen(int arr[], int length) 
	{
		int largestSum = (length%2 !=0)?(length-1)/2:length/2;
		int startPos=0;
		int oneCount=0;int zeroCount=0;
		int endPos=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]==1){
				oneCount++;
			}
			else{
				zeroCount++;
			}
			if(oneCount<=largestSum && zeroCount<=largestSum){
				if(oneCount==zeroCount){
					endPos=i;
				}
			}
			else{
				while((zeroCount>largestSum || oneCount>largestSum) && oneCount!=zeroCount){
					if(arr[startPos++]==1){
						oneCount--;
					}
					else{
						zeroCount--;
					}	
				}				
				if(oneCount==zeroCount){
					endPos=i;
				}
			}
		}
		while(oneCount!=zeroCount){
			if(arr[startPos++]==1){
				oneCount--;
			}
			else{
				zeroCount--;
			}
			if(oneCount==zeroCount){
				endPos=arr.length-1;
			}
		}
		if(endPos<=startPos){
			System.err.println("Non Equal");
		}
		else{
			System.out.println("startPos="+startPos+" endPos="+endPos);
		}
	}

	/* Driver program to test the above functions */
	public static void main(String[] args) 
	{
		LargestSubArray sub = new LargestSubArray();
		int arr[] = {0, 0, 1, 1, 0,1,1};
		int n = arr.length;

		sub.maxLen(arr, n);
	}
}