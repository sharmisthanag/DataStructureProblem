
public class FindTriplet {

	public static void main(String[] args) {
		FindTriplet triplet = new FindTriplet();
        int A[] = {1, 4, 45, 6, 10, 8};
        int sum = 22;
        findTiplet(A,sum);

        
	}

	private static void findTiplet(int[] a, int sum) {
		for(int i=0;i<a.length-2;i++){
			for(int j=i+1;j<a.length-1;j++){
				int arrsum=a[i]+a[j]+a[j+1];
				if(arrsum==sum){
					System.out.println(String.format("triplets found:%d,%d,%d",new Object[]{a[i],a[j],a[j+1]}));
				}
			}
		}
		
	}

}
