package code.generator.generator.common.constants;

public interface Const {
	
	/*
	 *  Bean名称 示例：InsUserBean
	 *  当要生成DAO或Service层代码时，请填写下方BEAN_NAMES参数
	 */
	public static String[] BEAN_NAMES = {"InsUserBean"};
	
	// BEAN名称前缀
	public static final String BO_PREFIX = "BO";
	// BEAN名称后缀
	public static final String BO_SUFFIX = "Bean";
	// Engine名称后缀
	public static final String ENGINE_SUFFIX = "Engine";
	
	// 营业库标志
	public static final String DB_SO = "SO";
	// party库标志
	public static final String DB_PARTY = "PARTY";

	public interface FileInfo {

		// 文件路径
		public static final String SO_DAO_PATH = "code/generator/generator/dao/so/interfaces";
		public static final String PARTY_DAO_PATH = "code/generator/generator/dao/party/interfaces";
		public static final String SO_DAO_IMPL_PATH = "code/generator/generator/dao/so/impl";
		public static final String PARTY_DAO_IMPL_PATH = "code/generator/generator/dao/party/impl";

		// 包名
		public static final String SO_DAO_PACKAGE = "code.generator.generator.dao.so.interfaces";
		public static final String PARTY_DAO_PACKAGE = "code.generator.generator.dao.party.interfaces";
		public static final String SO_DAO_IMPL_PACKAGE = "code.generator.generator.dao.so.impl";
		public static final String PARTY_DAO_IMPL_PACKAGE = "code.generator.generator.dao.party.impl";

		// 公共部分
		public static final String RT_1 = "\r\n";
		public static final String RT_2 = RT_1 + RT_1;
		public static final String BLANK_4 ="    ";
		public static final String BLANK_8 = BLANK_4 + BLANK_4;
		public static final String BLANK_12 = BLANK_8 + BLANK_4;
		public static final String BLANK_16 = BLANK_8 + BLANK_8;
	}

}
