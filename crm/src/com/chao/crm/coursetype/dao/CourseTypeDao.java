package com.chao.crm.coursetype.dao;

import java.util.List;

import com.chao.crm.coursetype.domain.CrmCourseType;

public interface CourseTypeDao {

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public List<CrmCourseType> findAll();

	/**
	 * ������ѯ
	 * 
	 * @param condition
	 *            ����ʽ��" and ..? and ..."
	 * @param params
	 * @return
	 */
	public List<CrmCourseType> findAll(String condition, Object[] params);

	/**
	 * ͨ��id��ѯ����
	 * 
	 * @param courseTypeId
	 * @return
	 */
	public CrmCourseType findById(String courseTypeId);

	/**
	 * ��������
	 * 
	 * @param courseType
	 */
	public void saveOrUpdate(CrmCourseType courseType);

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
	public List<CrmCourseType> findAll(String condition, Object[] params, int startIndex, int pageSize);

}