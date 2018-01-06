package code.generator.generator.common.util;

import code.generator.generator.common.exception.BusinessException;

public class ExceptionUtil {
	
	public static void throwBusinessException(String key, Object... args) throws Exception {
//		System.out.println(a+b);
		throw new BusinessException(key, args);
	}
	
	public static void throwBusinessException(String key) throws Exception {
//		System.out.println(a);
		throw new BusinessException(key);
	}

}
