package code.generator.generator;

import code.generator.generator.common.constants.Const;
import code.generator.generator.generator.DaoFileGenerator;
import code.generator.generator.generator.Generator;

public class DAOCreateClient {
	
	public static void main(String[] args) throws Exception{
		
//		new DaoFileGenerator().createDaoFile(Const.BEAN_NAMES, Const.DB_SO);
		new Generator().createDaoFile(Const.BEAN_NAMES, Const.DB_SO);
	}
}
