package code.generator.generator.common.exception;

import org.apache.commons.lang3.StringUtils;

import code.generator.generator.common.cache.GeneratorLocalCache;

/**
 * create by dh.deng.bowen 2018/1/6
 */
public class BusinessException extends Exception {

    public BusinessException() {
        super();
    }

    public BusinessException(String key) {
        super(wrapperMessage(key));
    }

    public BusinessException(String key, Object...args) {
        super(wrapperMessage(key, args));
    }

	private static String wrapperMessage(String key, Object... args) {

		String message = GeneratorLocalCache.getResource(key, args);

		if (StringUtils.isBlank(message)) {

			StringBuilder sb = new StringBuilder();
			sb.append("{");
			if (args != null) {
				for (int i = 0; i < args.length; ++i) {
					sb.append(args[i]);
					if (i != args.length - 1) {
						sb.append(",");
					}
				}
			}

			sb.append("}");
			message = "key=" + key + ",args=" + sb.toString();
		}
		return message;
	}
}
