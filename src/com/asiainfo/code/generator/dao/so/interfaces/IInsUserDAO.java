package com.asiainfo.code.generator.dao.so.interfaces;

public interface IInsUserDAO {

    Long queryNewId() throws Exception;

    InsUserBean queryBean(String condition, Map parameter) throws Exception;

    List<InsUserBean> queryBeanList(String condition, Map parameter) throws Exception;

    void insertBean(InsUserBean bean) throws Exception;

    void insertBeanList(List<InsUserBean> beanList) throws Exception;

    void updateBean(InsUserBean bean) throws Exception;

    void updateBeanList(List<InsUserBean> beanList) throws Exception;

    void deleteBean(InsUserBean bean) throws Exception;

    void deleteBeanList(List<InsUserBean> beanList) throws Exception;

}