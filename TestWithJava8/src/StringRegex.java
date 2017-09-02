import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringRegex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s="hellohi how r you<<<bcz<>>";
		Pattern regex = Pattern.compile("[*<>]");
		Matcher matcher = regex.matcher(s);
		if (matcher.find()){
		    System.out.println("match found");
		}
		else{
			System.out.println("mathcer not found");
		}
	}

}
