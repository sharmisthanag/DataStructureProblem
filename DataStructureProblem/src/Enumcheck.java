import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Enumcheck {

	public static void main(String[] args) {

		/*CopyOnWriteArrayList cw=new CopyOnWriteArrayList<>();
		cw.add("ss");
*/
		
		short s=32767;
		float f=0.0f;
		System.out.println(++f);

		System.out.println(1 << 30);
		int initialCapacity=16;
		System.out.println(initialCapacity>>>1);
		System.out.println(initialCapacity + (initialCapacity >>> 1) + 1);
		
		int n = 24;
		
		System.out.println(28>>>2);
		System.out.println(n>>>4);
		System.out.println(n>>>8);
		System.out.println(n>>>16);
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int in=(n < 0) ? 1 : (n >= (1 << 30)) ? 1 << 30 : n + 1;
        
		System.out.println(in);
		ConcurrentHashMap<String,String> ahm=new ConcurrentHashMap<>(16);
		
		
		ahm.put("d1", "j1");
		ahm.put("d2", "j2");
		ahm.put("d3", "j3");
		ahm.put("d4", "j4");
		ahm.put("d5", "j5");
		
		ahm.get("dd");

		Hashtable ht=new Hashtable();
		ht.put("dd", "jj");
		ht.get("dd");
		System.out.println("Currency.valueOf(\"DIME\").getCurrencyValue()=>"+Currency.valueOf("DIME").getCurrencyValue());
		Currency.DIME.setCurrencyValue(Currency.PENNY.getCurrencyValue());
		System.out.println(Currency.valueOf("DIME").getCurrencyValue());
		System.out.println(Currency.DIME);

	}

}
enum Currency {
	PENNY(1) {
		//@Override
		public void method() {
			// TODO Auto-generated method stub
			
		}
	}, NICKLE(5), DIME(10), QUARTER(25);
	private int value;

	private Currency(int value) {
		this.value = value;
	}
	public int getCurrencyValue() {
		return this.value ;
	}
	public void setCurrencyValue(int i) {
		this.value = i;
	}
	//public abstract void method();
}

