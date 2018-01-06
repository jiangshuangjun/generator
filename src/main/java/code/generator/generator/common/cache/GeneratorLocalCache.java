package code.generator.generator.common.cache;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import code.generator.generator.common.util.FileUtil;

/**
 *  create by dh.deng.bowen 20181/6
 */
public class GeneratorLocalCache {
	
	public static final String I18N_RESOURCE_ZH_CN_FILE = "i18n_resource_zh_cn.properties";
	
    private static HashMap<String, String> cache = new HashMap<String, String>(16);

    static{
    	
        try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
	private static void init() throws Exception {

		try {
			Properties prop = FileUtil.readProperties(I18N_RESOURCE_ZH_CN_FILE, null);
			for (Entry<Object, Object> entry : prop.entrySet()) {

				cache.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("i18n 缓存初始化失败");
		}
	}
	
	public static String getResource(String key, Object... args) {
		
		String resource = cache.get(key);
		
		if(StringUtils.isBlank(resource)) {
			
			return null;
		}
		
		if(null != args && args.length > 0) {
			
			for(int i = 0; i < args.length; i ++) {
				
				resource = StringUtils.replaceOnce(resource, "{" + i + "}", args[i].toString());
			}
		}
		return resource;
	}
	
}
