package code.generator.generator.generator;

import code.generator.generator.common.constants.Const;
import code.generator.generator.common.util.FileUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.*;

public class Generator {

    public void createDaoFile(String[] beanNames, String dbFlag) throws Exception {

        createBeanDao(beanNames,dbFlag);
        createBeanDaoImpl(beanNames,dbFlag);
    }

    /**
     * 生成DAO
     */
    private void createBeanDao(String[] beanNames, String dbFlag) throws Exception {
        for (String name : beanNames) {
            if (name == null || "".equals(name) || "".equals(name.trim()) || !name.endsWith("Bean")) {
                continue;
            }

            createDAO(name, dbFlag);
        }
    }

    private void createDAO(String boBeanName, String dbFlag) throws Exception {
        String pathName = "";
        if (Const.DB_SO.equals(dbFlag)) {
            pathName = System.getProperty("user.dir") + "/src/main/java/" + Const.FileInfo.SO_DAO_PATH + "/" + "I" + getTableName(boBeanName) + "DAO.java";
        } else if (Const.DB_PARTY.equals(dbFlag)) {
            pathName = System.getProperty("user.dir") + "/src/main/java/" + Const.FileInfo.PARTY_DAO_PATH + "/" + "I" + getTableName(boBeanName) + "DAO.java";
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
                writer.write("package " + Const.FileInfo.SO_DAO_PACKAGE + ";" + Const.FileInfo.RT_2);
            } else if (Const.DB_PARTY.equals(dbFlag)) {
                writer.write("package " + Const.FileInfo.PARTY_DAO_PACKAGE + ";" + Const.FileInfo.RT_2);
            }

            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("templete/easy_templete_dao.templete");
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

            String temp = "";
            while(null != (temp = br.readLine())){

                if(temp.indexOf("#.{table_name}#") != -1) {

                    temp = StringUtils.replace(temp, "#.{table_name}#", getTableName(boBeanName));
                }

                writer.write(temp);
                writer.newLine();
                writer.flush();
            }

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

    /**
     * 生成DAOImpl
     */
    private void createBeanDaoImpl(String[] beanNames, String dbFlag) throws Exception {
        for (String name : beanNames) {
            if (name == null || "".equals(name) || "".equals(name.trim()) || !name.endsWith("Bean")) {
                continue;
            }

            createDAOImpl(name, dbFlag);
        }
    }

    private void createDAOImpl(String boBeanName, String dbFlag) throws Exception {
        String pathName = "";
        if (Const.DB_SO.equals(dbFlag)) {
            pathName = System.getProperty("user.dir") + "/src/main/java/" + Const.FileInfo.SO_DAO_IMPL_PATH + "/" + getTableName(boBeanName) + "DAOImpl.java";
        } else if (Const.DB_PARTY.equals(dbFlag)) {
            pathName = System.getProperty("user.dir") + "/src/main/java/" + Const.FileInfo.PARTY_DAO_IMPL_PATH + "/" + getTableName(boBeanName) + "DAOImpl.java";
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
                writer.write("package " + Const.FileInfo.SO_DAO_IMPL_PACKAGE + ";" + Const.FileInfo.RT_2);
            } else if (Const.DB_PARTY.equals(dbFlag)) {
                writer.write("package " + Const.FileInfo.PARTY_DAO_IMPL_PACKAGE + ";" + Const.FileInfo.RT_2);
            }

            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("templete/esay_templete_daoimpl.templete");
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

            String temp = "";
            while(null != (temp = br.readLine())){

                if(temp.indexOf("#.{table_name}#") != -1) {

                    temp = StringUtils.replace(temp, "#.{table_name}#", getTableName(boBeanName));
                }

                writer.write(temp);
                writer.newLine();
                writer.flush();
            }


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


    public static void main(String[] args) throws Exception {

        new Generator().createDaoFile(Const.BEAN_NAMES, Const.DB_SO);
    }
}
