## 注意事项
* 本模块代码，可以在eclipse中直接使用
* 若要在idea中使用，创建文件时会报“系统找不到指定的路径”的io错误，原因时idea和eclipse在使用System.getProperty("user.dir")时获取的路径不一致
* 为了避免不必要的使用冲突，建议在eclipse中生成代码

## DAOCreateClient.java DAO代码生成执行器 使用说明
* 需要生成某张表的DAO层代码，需要在本模块代码中的Const.java中添加常量BEAN_NAMES的值，值为对应的某张表的bean，例如InsUserBean,BOAppCertInfoBean等
* 需要在DAOCreateClient.java的main方法中传入bean的数据源属性，如Const.DB_SO或Const.DB_PARTY，以便代码生成在对应的包下
* 生成的DAO接口和DAOImpl代码，需要导入正确的引用包，可以将生成的代码拷贝到项目适合的目录时，再执行导包操作，注意导入正确的引用包
* 支持覆盖生成，如果需要重新生成之前生成的代码，无需将之前的删除，可以再执行一次生成器，会将之前生成的代码覆盖
