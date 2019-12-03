package ec.com.andres.utils;

public class Utils {

	public static String padRightZeros(String inputString, int length) {
	    if (inputString.length() > length) {
	        return inputString.substring(0,length);
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    sb.append(inputString);
	    while (sb.length() < length ) {
	        sb.append(' ');
	    }
	 
	    return sb.toString();
	}
}
