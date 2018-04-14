package com.chao.crm.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	/**
	 * 保存记录
	 * 
	 * @param t
	 */
	public void save(T t);

	/**
	 * 更新记录
	 * 
	 * @param t
	 */
	public void update(T t);

	/**
	 * 删除记录
	 * 
	 * @param t
	 */
	public void delete(T t);

	/**
	 * 保存或更新
	 * 
	 * @param t
	 */
	public void saveOrUpdate(T t);

	/**
	 * 通过id查询
	 * 
	 * @param id
	 * @return
	 */
	public T findById(Serializable id);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<T> findAll();

	/**
	 * 条件查询
	 * 
	 * @param condition
	 *            ，格式：" and ..? and ..."
	 * @param params
	 * @return
	 */
	public List<T> findAll(String condition, Object[] params);

	/**
	 * 分页，查询总记录数
	 * 
	 * @param condition
	 * @param params
	 * @return
	 */
	public int getTotalRecord(String condition, Object[] params);

	/**
	 * 分页，查询结果
	 * 
	 * @param condition
	 *            条件
	 * @param params
	 *            条件实际参数
	 * @param startIndex
	 *            开始索引
	 * @param pageSize
	 *            每页显示个数
	 * @return
	 */
	public List<T> findAll(String condition, Object[] params, int startIndex, int pageSize);
	
	/**
	 * 离线条件查询，使用QBC
	 * @param criteria
	 * @return
	 */
	public List<T> findAll(DetachedCriteria criteria);
	/**
	 * 分页
	 * @param criteria
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<T> findAll(DetachedCriteria criteria , int startIndex ,int pageSize);
}
