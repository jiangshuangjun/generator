package code.generator.generator;

import code.generator.generator.common.Const;
import code.generator.generator.util.DaoUtil;

public class DAOCreateClient {
	
	public static void main(String[] args) throws Exception{
		DAOCreateClient daoCreateClient = new DAOCreateClient();
		DaoUtil daoUtils = new DaoUtil();
		
		/*
		 *  生成DAO接口及DAOImpl实现类
		 *  (1) 如需生成某个bean的DAO层代码，请填写下方的BEAN_NAMES参数(第二个参数)
		 *  (2) 该bean属于营业库还是party库，请填写下方的数据库标志参数(第三个参数)
		 */
		daoCreateClient.createDaoFile(daoUtils, Const.BEAN_NAMES, Const.DB_SO);
	}
	
	public void createDaoFile(DaoUtil daoUtils, String[] beanNames, String dbFlag) throws Exception {
		daoUtils.createBeanDao(beanNames, dbFlag);
		daoUtils.createBeanDaoImpl(beanNames, dbFlag);
	}

}
