package code.generator.generator;

import code.generator.generator.common.constants.Const;
import code.generator.generator.generator.DaoFileGenerator;

public class DAOCreateClient {
	
	public static void main(String[] args) throws Exception{
		
		new DaoFileGenerator().createDaoFile(Const.BEAN_NAMES, Const.DB_SO);
	}
}
