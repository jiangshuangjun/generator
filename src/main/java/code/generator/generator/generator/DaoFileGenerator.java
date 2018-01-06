package code.generator.generator.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import code.generator.generator.common.constants.Const;

public class DaoFileGenerator {
	
	// 文件路径
	private static final String SO_DAO_PATH = "code/generator/generator/dao/so/interfaces";
	private static final String PARTY_DAO_PATH = "code/generator/generator/dao/party/interfaces";
	private static final String SO_DAO_IMPL_PATH = "code/generator/generator/dao/so/impl";
	private static final String PARTY_DAO_IMPL_PATH = "code/generator/generator/dao/party/impl";
	
	// 包名
	private static final String SO_DAO_PACKAGE = "code.generator.generator.dao.so.interfaces";
	private static final String PARTY_DAO_PACKAGE = "code.generator.generator.dao.party.interfaces";
	private static final String SO_DAO_IMPL_PACKAGE = "code.generator.generator.dao.so.impl";
	private static final String PARTY_DAO_IMPL_PACKAGE = "code.generator.generator.dao.party.impl";
	
	// 公共部分
	private static final String RT_1 = "\r\n";
	private static final String RT_2 = RT_1 + RT_1;
	private static final String BLANK_4 ="    ";
	private static final String BLANK_8 = BLANK_4 + BLANK_4;
	private static final String BLANK_12 = BLANK_8 + BLANK_4;
	private static final String BLANK_16 = BLANK_8 + BLANK_8;
	
	public void createDaoFile(String[] beanNames, String dbFlag) throws Exception {
		
		createBeanDao(beanNames, dbFlag);
		createBeanDaoImpl(beanNames, dbFlag);
	}
	
	/**
	 * 生成DAO
	 */
	private void createBeanDao(String[] beanNames, String dbFlag) throws Exception {
		for (String name : beanNames) {
			if (name == null || "".equals(name) || "".equals(name.trim()) || !name.endsWith("Bean")) {
				continue;
			}
			
			this.createDAO(name, dbFlag);
		}
	}
	
	/**
	 * 生成DAOImpl
	 */
	private void createBeanDaoImpl(String[] beanNames, String dbFlag) throws Exception {
		for (String name : beanNames) {
			if (name == null || "".equals(name) || "".equals(name.trim()) || !name.endsWith("Bean")) {
				continue;
			}
			
			this.createDAOImpl(name, dbFlag);
		}
	}
	
	private void createDAO(String boBeanName, String dbFlag) throws Exception {
		String pathName = "";
		if (Const.DB_SO.equals(dbFlag)) {
			pathName = System.getProperty("user.dir") + "/src/main/java/" + SO_DAO_PATH + "/" + "I" + getTableName(boBeanName) + "DAO.java";
		} else if (Const.DB_PARTY.equals(dbFlag)) {
			pathName = System.getProperty("user.dir") + "/src/main/java/" + PARTY_DAO_PATH + "/" + "I" + getTableName(boBeanName) + "DAO.java";
		} else {
			throw new Exception("数据库标志传入错误，只能为SO或PARTY之一");
		}
		
		BufferedWriter writer = null;
		try {
			File daoFile = new File(pathName);
            // 目标文件所在的目录不存在，则创建父目录
            if (!daoFile.getParentFile().exists()) {
                daoFile.getParentFile().mkdirs();
            }
            // 目标文件已存在，则删除掉原目标文件
            if (daoFile.exists()) {
                daoFile.delete();
            }
            // 生成新目标文件
            daoFile.createNewFile();
			
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(daoFile), "UTF-8"));
			if (Const.DB_SO.equals(dbFlag)) {
				writer.write("package " + SO_DAO_PACKAGE + ";" + RT_2);
			} else if (Const.DB_PARTY.equals(dbFlag)) {
				writer.write("package " + PARTY_DAO_PACKAGE + ";" + RT_2);
			} 
			writer.write("public interface I" + getTableName(boBeanName) + "DAO {" + RT_2);
			
			// queryNewId()方法模板
			writer.write(BLANK_4 + "Long queryNewId() throws Exception;" + RT_2);
			// queryBean()方法模板
			writer.write(BLANK_4 + boBeanName + " queryBean(String condition, Map parameter) throws Exception;" + RT_2);
			// queryBeanList()方法模板
			writer.write(BLANK_4 + "List<" + boBeanName + "> queryBeanList(String condition, Map parameter) throws Exception;" + RT_2);
			// insertBean()方法模板
			writer.write(BLANK_4 + "void insertBean(" + boBeanName + " bean) throws Exception;" + RT_2);
			// insertBeanList()方法模板
			writer.write(BLANK_4 + "void insertBeanList(List<" + boBeanName + "> beanList) throws Exception;" + RT_2);
			// updateBean()方法模板
			writer.write(BLANK_4 + "void updateBean(" + boBeanName + " bean) throws Exception;" + RT_2);
			// updateBeanList()方法模板
			writer.write(BLANK_4 + "void updateBeanList(List<" + boBeanName + "> beanList) throws Exception;" + RT_2);
			// deleteBean()方法模板
			writer.write(BLANK_4 + "void deleteBean(" + boBeanName + " bean) throws Exception;" + RT_2);
			// deleteBeanList()方法模板
			writer.write(BLANK_4 + "void deleteBeanList(List<" + boBeanName + "> beanList) throws Exception;" + RT_2);
			
			writer.write("}");
			
			writer.flush();
			writer.close();
			showInfo(pathName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
	
	private void createDAOImpl(String boBeanName, String dbFlag) throws Exception {
		String pathName = "";
		if (Const.DB_SO.equals(dbFlag)) {
			pathName = System.getProperty("user.dir") + "/src/main/java/" + SO_DAO_IMPL_PATH + "/" + getTableName(boBeanName) + "DAOImpl.java";
		} else if (Const.DB_PARTY.equals(dbFlag)) {
			pathName = System.getProperty("user.dir") + "/src/main/java/" + PARTY_DAO_IMPL_PATH + "/" + getTableName(boBeanName) + "DAOImpl.java";
		} else {
			throw new Exception("数据库标志传入错误，只能为SO或PARTY之一");
		}
		
		BufferedWriter writer = null;
		try {
			File daoFile = new File(pathName);
            // 目标文件所在的目录不存在，则创建父目录
            if (!daoFile.getParentFile().exists()) {
                daoFile.getParentFile().mkdirs();
            }
            // 目标文件已存在，则删除掉原目标文件
            if (daoFile.exists()) {
                daoFile.delete();
            }
            // 生成新目标文件
            daoFile.createNewFile();
			
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(daoFile), "UTF-8"));
			if (Const.DB_SO.equals(dbFlag)) {
				writer.write("package " + SO_DAO_IMPL_PACKAGE + ";" + RT_2);
			} else if (Const.DB_PARTY.equals(dbFlag)) {
				writer.write("package " + PARTY_DAO_IMPL_PACKAGE + ";" + RT_2);
			} 
			writer.write("public class " + getTableName(boBeanName) + "DAOImpl implements I" + getTableName(boBeanName) + "DAO {" + RT_2);
			
			// queryNewId()方法模板
			this.queryNewId(boBeanName, writer);
			// queryBean()方法模板
			this.queryBean(boBeanName, writer);
			// queryBeanList()方法模板
			this.queryBeanList(boBeanName, writer);
			// insertBean()方法模板
			this.insertBean(boBeanName, writer);
			// insertBeanList()方法模板
			this.insertBeanList(boBeanName, writer);
			// updateBean()方法模板
			this.updateBean(boBeanName, writer);
			// updateBeanList()方法模板
			this.updateBeanList(boBeanName, writer);
			// deleteBean()方法模板
			this.deleteBean(boBeanName, writer);
			// deleteBeanList()方法模板
			this.deleteBeanList(boBeanName, writer);
			
			writer.write("}");
			
			writer.flush();
			writer.close();
			showInfo(pathName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
	
	private void deleteBeanList(String boBeanName, BufferedWriter writer) throws Exception {
		writer.write(BLANK_4 + "@Override" + RT_1);
		writer.write(BLANK_4 + "public void deleteBeanList(List<" + boBeanName + "> beanList) throws Exception {" + RT_1);
		writer.write(BLANK_8 + "if (beanList == null || beanList.isEmpty()) {" + RT_1);
		writer.write(BLANK_12 + "return;" + RT_1);
		writer.write(BLANK_8 + "}" + RT_2);
		writer.write(BLANK_8 + boBeanName + "[] beanArray = beanList.toArray(new " + boBeanName + "[beanList.size()]);" + RT_1);
		writer.write(BLANK_8 + "for (" + boBeanName + " bean : beanArray) {" + RT_1);
		writer.write(BLANK_12 + "if (!bean.isDeleted()) {" + RT_1);
		writer.write(BLANK_16 + "// {0}非删除模式" + RT_1);
		writer.write(BLANK_16 + "ExceptionUtil.throwBusinessException(\"CMSB00001000004\", \"" + boBeanName + "\");" + RT_1);
		writer.write(BLANK_12 + "}" + RT_1);
		writer.write(BLANK_8 + "}" + RT_2);
		writer.write(BLANK_8 + getEngineName(boBeanName) + ".saveBatch(beanArray);" + RT_1);
		writer.write(BLANK_4 + "}" + RT_2);
	}
	
	private void deleteBean(String boBeanName, BufferedWriter writer) throws Exception {
		writer.write(BLANK_4 + "@Override" + RT_1);
		writer.write(BLANK_4 + "public void deleteBean(" + boBeanName + " bean) throws Exception {" + RT_1);
		writer.write(BLANK_8 + "List<" + boBeanName + "> beanList = new ArrayList<" + boBeanName + ">();" + RT_2);
		writer.write(BLANK_8 + "beanList.add(bean);" + RT_2);
		writer.write(BLANK_8 + "this.deleteBeanList(beanList);" + RT_1);
		writer.write(BLANK_4 + "}" + RT_2);
	}
	
	private void updateBeanList(String boBeanName, BufferedWriter writer) throws Exception {
		writer.write(BLANK_4 + "@Override" + RT_1);
		writer.write(BLANK_4 + "public void updateBeanList(List<" + boBeanName + "> beanList) throws Exception {" + RT_1);
		writer.write(BLANK_8 + "if (beanList == null || beanList.isEmpty()) {" + RT_1);
		writer.write(BLANK_12 + "return;" + RT_1);
		writer.write(BLANK_8 + "}" + RT_2);
		writer.write(BLANK_8 + boBeanName + "[] beanArray = beanList.toArray(new " + boBeanName + "[beanList.size()]);" + RT_1);
		writer.write(BLANK_8 + "for (" + boBeanName + " bean : beanArray) {" + RT_1);
		writer.write(BLANK_12 + "if (!bean.isModified()) {" + RT_1);
		writer.write(BLANK_16 + "// {0}非修改模式" + RT_1);
		writer.write(BLANK_16 + "ExceptionUtil.throwBusinessException(\"CMSB00001000002\", \"" + boBeanName + "\");" + RT_1);
		writer.write(BLANK_12 + "}" + RT_1);
		writer.write(BLANK_8 + "}" + RT_2);
		writer.write(BLANK_8 + getEngineName(boBeanName) + ".saveBatch(beanArray);" + RT_1);
		writer.write(BLANK_4 + "}" + RT_2);
	}
	
	private void updateBean(String boBeanName, BufferedWriter writer) throws Exception {
		writer.write(BLANK_4 + "@Override" + RT_1);
		writer.write(BLANK_4 + "public void updateBean(" + boBeanName + " bean) throws Exception {" + RT_1);
		writer.write(BLANK_8 + "List<" + boBeanName + "> beanList = new ArrayList<" + boBeanName + ">();" + RT_2);
		writer.write(BLANK_8 + "beanList.add(bean);" + RT_2);
		writer.write(BLANK_8 + "this.updateBeanList(beanList);" + RT_1);
		writer.write(BLANK_4 + "}" + RT_2);
	}
	
	private void insertBeanList(String boBeanName, BufferedWriter writer) throws Exception {
		writer.write(BLANK_4 + "@Override" + RT_1);
		writer.write(BLANK_4 + "public void insertBeanList(List<" + boBeanName + "> beanList) throws Exception {" + RT_1);
		writer.write(BLANK_8 + "if (beanList == null || beanList.isEmpty()) {" + RT_1);
		writer.write(BLANK_12 + "return;" + RT_1);
		writer.write(BLANK_8 + "}" + RT_2);
		writer.write(BLANK_8 + boBeanName + "[] beanArray = beanList.toArray(new " + boBeanName + "[beanList.size()]);" + RT_1);
		writer.write(BLANK_8 + "for (" + boBeanName + " bean : beanArray) {" + RT_1);
		writer.write(BLANK_12 + "if (!bean.isNew()) {" + RT_1);
		writer.write(BLANK_16 + "// {0}非新增模式" + RT_1);
		writer.write(BLANK_16 + "ExceptionUtil.throwBusinessException(\"CMSB00001000001\", \"" + boBeanName + "\");" + RT_1);
		writer.write(BLANK_12 + "}" + RT_1);
		writer.write(BLANK_8 + "}" + RT_2);
		writer.write(BLANK_8 + getEngineName(boBeanName) + ".saveBatch(beanArray);" + RT_1);
		writer.write(BLANK_4 + "}" + RT_2);
	}
	
	private void insertBean(String boBeanName, BufferedWriter writer) throws Exception {
		writer.write(BLANK_4 + "@Override" + RT_1);
		writer.write(BLANK_4 + "public void insertBean(" + boBeanName + " bean) throws Exception {" + RT_1);
		writer.write(BLANK_8 + "List<" + boBeanName + "> beanList = new ArrayList<" + boBeanName + ">();" + RT_2);
		writer.write(BLANK_8 + "beanList.add(bean);" + RT_2);
		writer.write(BLANK_8 + "this.insertBeanList(beanList);" + RT_1);
		writer.write(BLANK_4 + "}" + RT_2);
	}
	
	private void queryBeanList(String boBeanName, BufferedWriter writer) throws Exception {
		writer.write(BLANK_4 + "@Override" + RT_1);
		writer.write(BLANK_4 + "public List<" + boBeanName + "> queryBeanList(String condition, Map parameter) throws Exception {" + RT_1);
		writer.write(BLANK_8 + boBeanName + "[] beanArray = " + getEngineName(boBeanName) + ".getBeans(condition, parameter);" + RT_2);
		writer.write(BLANK_8 + "if (beanArray != null && beanArray.length > 0) {" + RT_1);
		writer.write(BLANK_12 + "List<" + boBeanName + "> beanList = new ArrayList<" + boBeanName + ">();" + RT_1);
		writer.write(BLANK_12 + "Collections.addAll(beanList, beanArray);" + RT_1);
		writer.write(BLANK_12 + "return beanList;" + RT_1);
		writer.write(BLANK_8 + "}" + RT_2);
		writer.write(BLANK_8 + "return null;" + RT_1);
		writer.write(BLANK_4 + "}" + RT_2);
	}
	
	private void queryBean(String boBeanName, BufferedWriter writer) throws Exception {
		writer.write(BLANK_4 + "@Override" + RT_1);
		writer.write(BLANK_4 + "public " + boBeanName + " queryBean(String condition, Map parameter) throws Exception {" + RT_1);
		writer.write(BLANK_8 + boBeanName + "[] beanArray = " + getEngineName(boBeanName) + ".getBeans(condition, parameter);" + RT_2);
		writer.write(BLANK_8 + "if (beanArray == null || beanArray.length <= 0) {" + RT_1);
		writer.write(BLANK_12 + "return null;" + RT_1);
		writer.write(BLANK_8 + "}" + RT_2);
		writer.write(BLANK_8 + "if (beanArray != null && beanArray.length > 1) {" + RT_1);
		writer.write(BLANK_12 + "// 数据异常，根据查询条件获取到多条数据，请检查" + RT_1);
		writer.write(BLANK_12 + "ExceptionUtil.throwBusinessException(\"CMSB00002000006\");" + RT_1);
		writer.write(BLANK_8 + "}" + RT_2);
		writer.write(BLANK_8 + "return beanArray[0];" + RT_1);
		writer.write(BLANK_4 + "}" + RT_2);
	}
	
	private void queryNewId(String boBeanName, BufferedWriter writer) throws Exception {
		writer.write(BLANK_4 + "@Override" + RT_1);
		writer.write(BLANK_4 + "public Long queryNewId() throws Exception {" + RT_1);
		writer.write(BLANK_8 + "return " + getEngineName(boBeanName) + ".getNewId().longValue();" + RT_1);
		writer.write(BLANK_4 + "}" + RT_2);
	}
	
	private String getTableName(String boBeanName) throws Exception {
		String result = "";
		
		if (boBeanName.startsWith(Const.BO_PREFIX) && boBeanName.endsWith(Const.BO_SUFFIX)) {
			result = boBeanName.substring(boBeanName.indexOf(Const.BO_PREFIX) + Const.BO_PREFIX.length(), boBeanName.indexOf(Const.BO_SUFFIX));
		} else if (boBeanName.endsWith(Const.BO_SUFFIX)) {
			result = boBeanName.substring(0, boBeanName.indexOf(Const.BO_SUFFIX));
		} else {
			throw new Exception("传入BoBean名称非法：" + boBeanName);
		}
		
		return result;
	}
	
	private String getEngineName(String boBeanName) throws Exception {
		return boBeanName.replaceAll(Const.BO_SUFFIX, Const.ENGINE_SUFFIX);
	}
	
	public void showInfo(String info) {
		System.out.println("创建文件"+ info+ "成功");
	}
	
}
