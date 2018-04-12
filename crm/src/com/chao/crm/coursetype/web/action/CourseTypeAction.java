package com.chao.crm.coursetype.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.chao.crm.coursetype.domain.CrmCourseType;
import com.chao.crm.coursetype.service.CourseTypeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CourseTypeAction extends ActionSupport implements ModelDriven<CrmCourseType> {

	// 封装数据
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

	// -----------------------------------------------------------------

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public String findAll() {
		/*
		 * 1简单查询 List<CrmCourseType> allCourseType =
		 * this.courseTypeService.findAll(); // * 查询结果存在值栈 , jsp 通过“#key”获得
		 * ActionContext.getContext().put("allCourseType", allCourseType);
		 */

		/*
		 * 2 条件查询
		 */
		List<CrmCourseType> allCourseType = this.courseTypeService.findAll(courseType);
		ActionContext.getContext().put("allCourseType", allCourseType);

		return "findAll";
	}

	/**
	 * 添加或编辑显示jsp页面
	 * 
	 * @return
	 */
	public String addOrEditUI() {
		// 如果有id就是编辑，编辑需要查询详情
		if (StringUtils.isNotBlank(this.courseType.getCourseTypeId())) {
			// 将查询的详情压入到栈顶，方便标签自动的回显
			CrmCourseType findCourseType = this.courseTypeService.findById(this.courseType.getCourseTypeId());
			ActionContext.getContext().getValueStack().push(findCourseType);
		}

		return "addOrEditUI";
	}

	/**
	 * 添加或编辑 功能
	 * 
	 * @return
	 */
	public String addOrEdit() {
		this.courseTypeService.addOrEdit(courseType);
		return "addOrEdit";
	}

}
