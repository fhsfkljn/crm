package com.chao.crm.coursetype.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.weaver.ast.And;

import com.chao.crm.coursetype.dao.CourseTypeDao;
import com.chao.crm.coursetype.domain.CrmCourseType;
import com.chao.crm.coursetype.service.CourseTypeService;
import com.chao.crm.page.PageBean;

public class CourseTypeServiceImpl implements CourseTypeService {

	private CourseTypeDao courseTypeDao;

	public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
		this.courseTypeDao = courseTypeDao;
	}

	@Override
	public List<CrmCourseType> findAll() {
		return courseTypeDao.findAll();
	}

	@Override
	public List<CrmCourseType> findAll(CrmCourseType courseType) {
		// 1.1 ƴ�ղ�ѯ����
		StringBuilder builder = new StringBuilder();
		// 1.2 ƴ��ʵ�ʲ��� , �����ظ���˳�� --> List
		List<Object> paramsList = new ArrayList<Object>();

		// 2 ��������
		// 2.1 �γ����
		if (StringUtils.isNotBlank(courseType.getCourseName())) {
			builder.append(" and courseName like ?");
			paramsList.add("%" + courseType.getCourseName() + "%");
		}
		// 2.2 �γ̼��
		if (StringUtils.isNotBlank(courseType.getRemark())) {
			builder.append(" and remark like ?");
			paramsList.add("%" + courseType.getRemark() + "%");
		}
		// 2.3 ��ѧʱ��
		if (StringUtils.isNotBlank(courseType.getTotalStart())) {
			builder.append(" and total >= ?");
			paramsList.add(Integer.parseInt(courseType.getTotalStart()));
		}
		if (StringUtils.isNotBlank(courseType.getTotalEnd())) {
			builder.append(" and total <= ?");
			paramsList.add(Integer.parseInt(courseType.getTotalEnd()));
		}
		// 2.4�γ̷���
		if (StringUtils.isNotBlank(courseType.getCourseCostStart())) {
			builder.append(" and courseCost >= ?");
			paramsList.add(Double.parseDouble(courseType.getCourseCostStart()));
		}
		if (StringUtils.isNotBlank(courseType.getCourseCostEnd())) {
			builder.append(" and courseCost <= ?");
			paramsList.add(Double.parseDouble(courseType.getCourseCostEnd()));
		}

		// 3 ʹ��
		// ���� , ��ʽ��" and ..? and ..."
		String condition = builder.toString();
		// ʵ�ʲ���
		Object[] params = paramsList.toArray();

		return courseTypeDao.findAll(condition, params);
	}
	
	@Override
	public CrmCourseType findById(String courseTypeId) {
		return this.courseTypeDao.findById(courseTypeId);
	}
	
	@Override
	public void addOrEdit(CrmCourseType courseType) {
		this.courseTypeDao.saveOrUpdate(courseType);
	}
	
	@Override
	public PageBean<CrmCourseType> findAll(CrmCourseType courseType, int pageNum, int pageSize) {
		//1 ������ѯ
		//1.1 ƴ�ղ�ѯ����
		StringBuilder builder = new StringBuilder();
		//1.2 ƴ��ʵ�ʲ��� , �����ظ���˳�� --> List
		List<Object> paramsList = new ArrayList<Object>();
		
		//2 ��������
		// 2.1 �γ����
		if(StringUtils.isNotBlank(courseType.getCourseName())){
			builder.append(" and courseName like ?");
			paramsList.add("%"+courseType.getCourseName()+"%");
		}
		// 2.2 �γ̼��
		if(StringUtils.isNotBlank(courseType.getRemark())){
			builder.append(" and remark like ?");
			paramsList.add("%"+courseType.getRemark()+"%");
		}
		// 2.3 ��ѧʱ��
		if(StringUtils.isNotBlank(courseType.getTotalStart())){
			builder.append(" and total >= ?");
			paramsList.add(Integer.parseInt(courseType.getTotalStart()));
		}
		if(StringUtils.isNotBlank(courseType.getTotalEnd())){
			builder.append(" and total <= ?");
			paramsList.add(Integer.parseInt(courseType.getTotalEnd()));
		}
		// 2.4�γ̷���
		if(StringUtils.isNotBlank(courseType.getCourseCostStart())){
			builder.append(" and courseCost >= ?");
			paramsList.add(Double.parseDouble(courseType.getCourseCostStart()));
		}
		if(StringUtils.isNotBlank(courseType.getCourseCostEnd())){
			builder.append(" and courseCost <= ?");
			paramsList.add(Double.parseDouble(courseType.getCourseCostEnd()));
		}
		
		//3 ʹ��
		// ���� , ��ʽ��" and ..? and ..."
		String condition = builder.toString();
		// ʵ�ʲ���
		Object[] params = paramsList.toArray();
		
		//-------------------------------------------------
		
		//2��ҳ
		//2.1 �ܼ�¼��
		int totalRecord = this.courseTypeDao.getTotalRecord(condition,params);
		//2.2 ��������
		PageBean<CrmCourseType> pageBean = new PageBean<CrmCourseType>(pageNum, pageSize, totalRecord);
		//2.3 ��ҳ����
		List<CrmCourseType> data = this.courseTypeDao.findAll(condition, params,pageBean.getStartIndex(),pageBean.getPageSize());
		pageBean.setData(data);
		
		return pageBean;
	}

}