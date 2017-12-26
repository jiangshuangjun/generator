package code.generator.generator;

public class ExceptionUtil {
	
	public static void throwBusinessException(String a, String b) throws Exception {
		System.out.println(a + b);
	}
	
	public static void throwBusinessException(String a) throws Exception {
		System.out.println(a);
	}

}
