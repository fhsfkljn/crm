package com.chao.crm.coursetype.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.chao.crm.coursetype.domain.CrmCourseType;
import com.chao.crm.coursetype.service.CourseTypeService;
import com.chao.crm.page.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CourseTypeAction extends ActionSupport implements ModelDriven<CrmCourseType> {

	// ��װ����
	private CrmCourseType courseType = new CrmCourseType();

	@Override
	public CrmCourseType getModel() {
		return courseType;
	}

	// service
	private CourseTypeService courseTypeService;

	public void setCourseTypeService(CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}

	// ��ҳ����
	private int pageNum = 1;

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	private int pageSize = 2; // �̶�ֵ

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	// -----------------------------------------------------------------

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public String findAll() {
		/*1�򵥲�ѯ
		List<CrmCourseType> allCourseType = this.courseTypeService.findAll();
		// * ��ѯ�������ֵջ , jsp ͨ����#key�����
		ActionContext.getContext().put("allCourseType", allCourseType);
		*/
		
		/*2 ������ѯ
		List<CrmCourseType> allCourseType = this.courseTypeService.findAll(courseType);
		ActionContext.getContext().put("allCourseType", allCourseType);
		 */
		
		//3 ��ҳ + ����
		PageBean<CrmCourseType> pageBean = this.courseTypeService.findAll(courseType, pageNum, pageSize);
		ActionContext.getContext().put("pageBean", pageBean);
		
		return "findAll";
	}

	/**
	 * ���ӻ�༭��ʾjspҳ��
	 * 
	 * @return
	 */
	public String addOrEditUI() {
		// �����id���Ǳ༭���༭��Ҫ��ѯ����
		if (StringUtils.isNotBlank(this.courseType.getCourseTypeId())) {
			// ����ѯ������ѹ�뵽ջ���������ǩ�Զ��Ļ���
			CrmCourseType findCourseType = this.courseTypeService.findById(this.courseType.getCourseTypeId());
			ActionContext.getContext().getValueStack().push(findCourseType);
		}

		return "addOrEditUI";
	}

	/**
	 * ���ӻ�༭ ����
	 * 
	 * @return
	 */
	public String addOrEdit() {
		this.courseTypeService.addOrEdit(courseType);
		return "addOrEdit";
	}

}