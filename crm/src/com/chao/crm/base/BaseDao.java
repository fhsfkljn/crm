package com.chao.crm.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	/**
	 * �����¼
	 * 
	 * @param t
	 */
	public void save(T t);

	/**
	 * ���¼�¼
	 * 
	 * @param t
	 */
	public void update(T t);

	/**
	 * ɾ����¼
	 * 
	 * @param t
	 */
	public void delete(T t);

	/**
	 * ��������
	 * 
	 * @param t
	 */
	public void saveOrUpdate(T t);

	/**
	 * ͨ��id��ѯ
	 * 
	 * @param id
	 * @return
	 */
	public T findById(Serializable id);

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public List<T> findAll();

	/**
	 * ������ѯ
	 * 
	 * @param condition
	 *            ����ʽ��" and ..? and ..."
	 * @param params
	 * @return
	 */
	public List<T> findAll(String condition, Object[] params);

	/**
	 * ��ҳ����ѯ�ܼ�¼��
	 * 
	 * @param condition
	 * @param params
	 * @return
	 */
	public int getTotalRecord(String condition, Object[] params);

	/**
	 * ��ҳ����ѯ���
	 * 
	 * @param condition
	 *            ����
	 * @param params
	 *            ����ʵ�ʲ���
	 * @param startIndex
	 *            ��ʼ����
	 * @param pageSize
	 *            ÿҳ��ʾ����
	 * @return
	 */
	public List<T> findAll(String condition, Object[] params, int startIndex, int pageSize);
	
	/**
	 * ����������ѯ��ʹ��QBC
	 * @param criteria
	 * @return
	 */
	public List<T> findAll(DetachedCriteria criteria);
	/**
	 * ��ҳ
	 * @param criteria
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<T> findAll(DetachedCriteria criteria , int startIndex ,int pageSize);
}
