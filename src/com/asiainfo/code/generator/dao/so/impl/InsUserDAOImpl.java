package com.asiainfo.code.generator.dao.so.impl;

public class InsUserDAOImpl implements IInsUserDAO {

    @Override
    public Long queryNewId() throws Exception {
        return InsUserEngine.getNewId().longValue();
    }

    @Override
    public InsUserBean queryBean(String condition, Map parameter) throws Exception {
        InsUserBean[] beanArray = InsUserEngine.getBeans(condition, parameter);

        if (beanArray == null || beanArray.length <= 0) {
            return null;
        }

        if (beanArray != null && beanArray.length > 1) {
            // 数据异常，根据查询条件获取到多条数据，请检查
            ExceptionUtil.throwBusinessException("CMSB00002000006");
        }

        return beanArray[0];
    }

    @Override
    public List<InsUserBean> queryBeanList(String condition, Map parameter) throws Exception {
        InsUserBean[] beanArray = InsUserEngine.getBeans(condition, parameter);

        if (beanArray != null && beanArray.length > 0) {
            List<InsUserBean> beanList = new ArrayList<InsUserBean>();
            Collections.addAll(beanList, beanArray);
            return beanList;
        }

        return null;
    }

    @Override
    public void insertBean(InsUserBean bean) throws Exception {
        List<InsUserBean> beanList = new ArrayList<InsUserBean>();

        beanList.add(bean);

        this.insertBeanList(beanList);
    }

    @Override
    public void insertBeanList(List<InsUserBean> beanList) throws Exception {
        if (beanList == null || beanList.isEmpty()) {
            return;
        }

        InsUserBean[] beanArray = beanList.toArray(new InsUserBean[beanList.size()]);
        for (InsUserBean bean : beanArray) {
            if (!bean.isNew()) {
                // {0}非新增模式
                ExceptionUtil.throwBusinessException("CMSB00001000001", "InsUserBean");
            }
        }

        InsUserEngine.saveBatch(beanArray);
    }

    @Override
    public void updateBean(InsUserBean bean) throws Exception {
        List<InsUserBean> beanList = new ArrayList<InsUserBean>();

        beanList.add(bean);

        this.updateBeanList(beanList);
    }

    @Override
    public void updateBeanList(List<InsUserBean> beanList) throws Exception {
        if (beanList == null || beanList.isEmpty()) {
            return;
        }

        InsUserBean[] beanArray = beanList.toArray(new InsUserBean[beanList.size()]);
        for (InsUserBean bean : beanArray) {
            if (!bean.isModified()) {
                // {0}非修改模式
                ExceptionUtil.throwBusinessException("CMSB00001000002", "InsUserBean");
            }
        }

        InsUserEngine.saveBatch(beanArray);
    }

    @Override
    public void deleteBean(InsUserBean bean) throws Exception {
        List<InsUserBean> beanList = new ArrayList<InsUserBean>();

        beanList.add(bean);

        this.deleteBeanList(beanList);
    }

    @Override
    public void deleteBeanList(List<InsUserBean> beanList) throws Exception {
        if (beanList == null || beanList.isEmpty()) {
            return;
        }

        InsUserBean[] beanArray = beanList.toArray(new InsUserBean[beanList.size()]);
        for (InsUserBean bean : beanArray) {
            if (!bean.isDeleted()) {
                // {0}非删除模式
                ExceptionUtil.throwBusinessException("CMSB00001000004", "InsUserBean");
            }
        }

        InsUserEngine.saveBatch(beanArray);
    }

}