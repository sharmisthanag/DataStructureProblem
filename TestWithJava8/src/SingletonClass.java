import java.lang.reflect.Constructor;

public class SingletonClass {
	static {

		LazySingletonWithDoubleChecking instance2 = null;
        try
        {
            Constructor[] constructors = 
            		LazySingletonWithDoubleChecking.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) 
            {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instance2 = (LazySingletonWithDoubleChecking) constructor.newInstance();
                System.out.println("LazySingletonWithDoubleChecking=>"+instance2.hashCode());
                break;
            }
        }catch(Exception e) {
        	
        }
	
	}
	public static void main(String[] args) {
		LazySingletonWithDoubleChecking instance1 = LazySingletonWithDoubleChecking.getInstance();
		/*LazySingletonWithDoubleChecking instance2 = null;
        try
        {
            Constructor[] constructors = 
            		LazySingletonWithDoubleChecking.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) 
            {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instance2 = (LazySingletonWithDoubleChecking) constructor.newInstance();
                break;
            }
        }
     
        catch (Exception e) 
        {
            e.printStackTrace();
        }
         */
    System.out.println("instance1.hashCode():- "
                                      + instance1.hashCode());
  /*  System.out.println("instance2.hashCode():- "
                                      + instance2.hashCode());
	*/	
	}

}
//Eager initialization
class EagerSingleton {
	private static volatile EagerSingleton eagerSingleton=new EagerSingleton();
	private EagerSingleton(){}
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
		if(lLazySingletonWithDoubleChecking != null) {
			throw new RuntimeException("call LazySingletonWithDoubleChecking.getInstance()");
		}
		
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
			System.out.println("8888");
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
	protected Object readResolve()
    {
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