package com.chao.crm.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.chao.crm.base.BaseDao;
import com.chao.crm.page.PageHibernateCallback;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	// T ����ʱ��ע�ͱ�����������ʱ���ſ��Ի�þ��������
	private Class<?> beanClass;

	public BaseDaoImpl() {
		// �������ʱ������ , BaseDaoImpl<CrmStaff>��������������
		ParameterizedType paramType = (ParameterizedType) this.getClass().getGenericSuperclass();
		// ���ʵ�ʲ����� ,������С���ʱֻ��һ��
		beanClass = (Class<?>) paramType.getActualTypeArguments()[0];
	}

	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public void saveOrUpdate(T t) {
		this.getHibernateTemplate().saveOrUpdate(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Serializable id) {
		return (T) this.getHibernateTemplate().get(beanClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		// getName() ������ȫ�޶����ƣ� com.itheima.crm.staff.domain.CrmStaff
		return this.getHibernateTemplate().find("from " + beanClass.getName());

		// hql
		// session.createQuery("from CrmStaff"); //��д�������Զ����� ��
		// <hibernate-mapping auto-import="true">
		// session.createQuery("from com.itheima.crm.staff.domain.CrmStaff");
		// //����д��
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(String condition, Object[] params) {
		String hql = "from "+beanClass.getName()+" where 1=1 " + condition;
		return this.getHibernateTemplate().find(hql , params);
	}


	@Override
	public int getTotalRecord(String condition, Object[] params) {
		String hql = "select count(c) from "+beanClass.getName()+" c where 1=1 " + condition;
		@SuppressWarnings("unchecked")
		List<Long> list = this.getHibernateTemplate().find(hql,params);
		return list.get(0).intValue();
	}

	@Override
	public List<T> findAll(String condition, Object[] params, int startIndex, int pageSize) {
		String hql = "from "+beanClass.getName()+" where 1=1 " + condition;
		return this.getHibernateTemplate().execute(new PageHibernateCallback<T>().setHql(hql).setParams(params).setPageSize(pageSize).setStartIndex(startIndex));
	}
	
	@Override
	public List<T> findAll(DetachedCriteria criteria) {
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<T> findAll(DetachedCriteria criteria, int startIndex, int pageSize) {
		return this.getHibernateTemplate().findByCriteria(criteria, startIndex, pageSize);
	}

}
