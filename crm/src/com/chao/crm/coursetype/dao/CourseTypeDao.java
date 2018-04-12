package com.chao.crm.coursetype.dao;

import java.util.List;

import com.chao.crm.coursetype.domain.CrmCourseType;

public interface CourseTypeDao {

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<CrmCourseType> findAll();
	
	/**
	 * 条件查询
	 * @param condition ，格式：" and ..? and ..."
	 * @param params
	 * @return
	 */
	public List<CrmCourseType> findAll(String condition, Object[] params);
	
	/**
	 * 通过id查询详情
	 * @param courseTypeId
	 * @return
	 */
	public CrmCourseType findById(String courseTypeId);
	
	/**
	 * 保存或更新
	 * @param courseType
	 */
	public void saveOrUpdate(CrmCourseType courseType);

}
