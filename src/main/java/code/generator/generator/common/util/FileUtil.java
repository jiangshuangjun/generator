package code.generator.generator.common.util;

import code.generator.generator.DAOCreateClient;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 *  create by dh.deng.bowen 2018/1/6
 */
public class FileUtil {

	private static final String FILE_ENCODING = "UTF-8";

	public static String readFile2Str(String fileName, Class<?> clazz) throws Exception {

		if (StringUtils.isBlank(fileName)) {

			return null;
		}

		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);

		if (null != clazz) {

			is = clazz.getClassLoader().getResourceAsStream(fileName);
		}

		if (null == is) {

			return null;
		}

		InputStreamReader isr = new InputStreamReader(is, FILE_ENCODING);
		BufferedReader br = new BufferedReader(isr);

		String temp = "";
		StringBuffer rtn = new StringBuffer();
		while (null != (temp = br.readLine())) {

			rtn.append(temp);
		}

		return rtn.toString();
	}

	public static Properties readProperties(String fileName, Class<?> clazz) throws Exception {

		if (StringUtils.isBlank(fileName)) {

			return null;
		}

		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);

		if (null != clazz) {

			is = clazz.getClassLoader().getResourceAsStream(fileName);
		}

		if (null == is) {

			return null;
		}

		InputStreamReader isr = new InputStreamReader(is, FILE_ENCODING);

		Properties prop = new Properties();
		prop.load(isr);

		return prop;
	}

}
