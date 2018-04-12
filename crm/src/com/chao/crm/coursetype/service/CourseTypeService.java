package com.chao.crm.coursetype.service;

import java.util.List;

import com.chao.crm.coursetype.domain.CrmCourseType;

public interface CourseTypeService {

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public List<CrmCourseType> findAll();
	
	/**
	 * ���������Ĳ�ѯ����
	 * @param courseType
	 * @return
	 */
	public List<CrmCourseType> findAll(CrmCourseType courseType);
	
	/**
	 * ͨ��id��ѯ����
	 * @param courseTypeId
	 * @return
	 */
	public CrmCourseType findById(String courseTypeId);
	
	/**
	 * ��������
	 * @param courseType
	 */
	public void addOrEdit(CrmCourseType courseType);

}
