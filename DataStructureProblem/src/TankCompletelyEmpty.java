//http://www.geeksforgeeks.org/number-days-tank-will-become-empty/
public class TankCompletelyEmpty {

	public static void main(String[] args) {
		int tankCapacity=9999999;
		int filledWater=99;
		System.out.println(findTankCompletelyEmpty(tankCapacity,filledWater));

	}

	private static int findTankCompletelyEmpty(int tankCapacity,int filledWater) {
		int day=0;
		int capacity = tankCapacity;
		while(tankCapacity>0){
			day++;
			if(day>1){
				tankCapacity=(tankCapacity+filledWater)>=capacity?capacity:tankCapacity+filledWater;
			}
			tankCapacity=(tankCapacity-day)<=0?0:tankCapacity-day;
			
		}
		return day;
	}

}
