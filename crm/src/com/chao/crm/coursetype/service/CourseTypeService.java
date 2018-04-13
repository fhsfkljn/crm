package com.chao.crm.coursetype.service;

import java.util.List;

import com.chao.crm.coursetype.domain.CrmCourseType;
import com.chao.crm.page.PageBean;

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
	
	/**
	 * ��ҳ + ������ѯ
	 * @param courseType ����
	 * @param pageNum ��ǰҳ
	 * @param pageSize ÿҳ��ʾ����
	 * @return
	 */
	public PageBean<CrmCourseType> findAll(CrmCourseType courseType , int pageNum ,int pageSize);

}