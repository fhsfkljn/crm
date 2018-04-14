package com.chao.crm.base;

import java.lang.reflect.ParameterizedType;

import com.chao.crm.coursetype.service.CourseTypeService;
import com.chao.crm.department.service.DepartmentService;
import com.chao.crm.post.service.PostService;
import com.chao.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	// 1 ��װ����
	private T t;

	@Override
	public T getModel() {
		return t;
	}

	// 1.1 ʵ����t
	public BaseAction() {
		try {
			// 1 ���T����ʱClass
			ParameterizedType paramType = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) paramType.getActualTypeArguments()[0];
			// 2 ���䴴��ʵ��
			t = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 2 springע��service�����
	// * �ṩsetter��������spring����ע���
	// * �ṩgetter��������������Ի��springע��Ķ���ġ�
	// Ա��
	private StaffService staffService;

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	public StaffService getStaffService() {
		return staffService;
	}

	// ְ��
	private PostService postService;

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	// ����
	private DepartmentService departmentService;

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	// �γ����
	private CourseTypeService courseTypeService;

	public void setCourseTypeService(CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}

	public CourseTypeService getCourseTypeService() {
		return courseTypeService;
	}

	// �༶
//	private ClassesService classesService;
//
//	public void setClassesService(ClassesService classesService) {
//		this.classesService = classesService;
//	}
//
//	public ClassesService getClassesService() {
//		return classesService;
//	}

	// 3 ��ҳ����
	private int pageNum = 1;

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageNum() {
		return pageNum;
	}

	private int pageSize = 2; // �̶�ֵ

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	// 4 ��ֵջ����
	public void push(Object o) {
		ActionContext.getContext().getValueStack().push(o);
	}

	public void set(String key, Object o) {
		ActionContext.getContext().getValueStack().set(key, o);
	}

	public void put(String key, Object value) {
		ActionContext.getContext().put(key, value);
	}

	public void putSession(String key, Object value) {
		ActionContext.getContext().getSession().put(key, value);
	}

	public void putApplication(String key, Object value) {
		ActionContext.getContext().getApplication().put(key, value);
	}

}