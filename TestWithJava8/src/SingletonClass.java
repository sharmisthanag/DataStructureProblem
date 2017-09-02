
public class SingletonClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//Eager initialization
class EagerSingleton {
	private static volatile EagerSingleton eagerSingleton=new EagerSingleton();
	private EagerSingleton(){

	}
	public static EagerSingleton getInstance(){
		return eagerSingleton;
	}
}
//Lazy initialization
final class LazySingleton{
	private static volatile LazySingleton lLazySingleton;
	private LazySingleton(){
		
	}
	public static LazySingleton getInstance(){
		if(lLazySingleton==null){
			synchronized(LazySingleton.class){
				lLazySingleton=new LazySingleton();
			}
		}
		return lLazySingleton;
	}

}
//double-checked locking. 
class LazySingletonWithDoubleChecking{
	private static volatile LazySingletonWithDoubleChecking lLazySingletonWithDoubleChecking;
	private LazySingletonWithDoubleChecking(){

	}
	public static LazySingletonWithDoubleChecking getInstance(){
		if(lLazySingletonWithDoubleChecking==null){
			synchronized(LazySingletonWithDoubleChecking.class){
				if(lLazySingletonWithDoubleChecking==null){
					lLazySingletonWithDoubleChecking = new LazySingletonWithDoubleChecking();
				}
			}
		}
		return lLazySingletonWithDoubleChecking;
	}
}
//Static block initialization
class StaticBlockSingleton{
	private static final  StaticBlockSingleton sStaticBlockSingleton;
	static{
		
			sStaticBlockSingleton = new StaticBlockSingleton();
		
	}
	private StaticBlockSingleton(){
	}
	
	public static StaticBlockSingleton getInstance() {
		return sStaticBlockSingleton;
	}
}
//Bill pugh solution->creating sttaic inner class
class BillPughSingleton {

	private BillPughSingleton(){

	}
	private static class BillPughSingletonLazyLoad{
		private static BillPughSingleton bBillPughSingleton=new BillPughSingleton();
	}
	public static BillPughSingleton getInstance(){
		return BillPughSingletonLazyLoad.bBillPughSingleton;
	}
}
//Using Enum
enum EnumSingleton{
	enumSingleton;
	private int i=10;
	
	public EnumSingleton getInstance(){
		return enumSingleton;
	}
	
}