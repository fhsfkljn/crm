package com.chao.crm.staff.web.action;

import java.util.List;

import com.chao.crm.department.domain.CrmDepartment;
import com.chao.crm.department.service.DepartmentService;
import com.chao.crm.staff.domain.CrmStaff;
import com.chao.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff> {

	// ��װ����
	private CrmStaff staff = new CrmStaff();

	@Override
	public CrmStaff getModel() {
		return staff;
	}

	// Ĭ�ϰ�������ע��
	// Ա��
	private StaffService staffService;

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	// ����
	private DepartmentService departmentService;

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	// ----------------------------------------------

	/**
	 * Ա����¼
	 * 
	 * @return
	 */
	public String login() {
		// 1 ��ѯԱ��
		CrmStaff findStaff = staffService.login(staff);
		// 2 �Ƿ�ɹ�
		if (findStaff != null) {
			// �ɹ�
			// 3.1 session�����򱣴�����
			ActionContext.getContext().getSession().put("loginStaff", findStaff);
			// 3.2 �ض�����ҳ -- xml����
			return "success";
		}
		// 4 ���ɹ�
		this.addFieldError("", "�û��������벻ƥ��");
		// * ����ת����ʾ
		return "login";
	}

	/**
	 * ��ʾ��ҳ
	 * 
	 * @return
	 */
	public String home() {
		return "home";
	}

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public String findAll() {
		// 1��ѯ����
		List<CrmStaff> allStaff = staffService.findAllStaff();
		// 2 �������ŵ�ֵջ������jsp�������
		// * ��ʽ1��context (map)��� put(key ,value) ��jspҳ���� ��#key�� ��
		// ActionContext.getContext().put(key, value)
		// * ��ʽ2��root (ֵջ) ��push(obj) ��һ������ΪJavaBean �� Map ��jspҳ���á��������� ��key��
		// ��
		// ActionContext.getContext().getValueStack().push(o)
		// * ��ʽ3��root (ֵջ) ��set(key ,value) ,һ������ΪList ��jspҳ���á�key��
		// set() �ײ� new Map(key,value) ���� push(map )

		// ʹ�� context�������
		ActionContext.getContext().put("allStaff", allStaff);

		return "findAll";
	}

	/**
	 * �༭ǰ����
	 * 
	 * @return
	 */
	public String editUI() {
		// 1 ͨ��id��ѯԱ��
		CrmStaff findStaff = this.staffService.findById(staff.getStaffId());
		ActionContext.getContext().getValueStack().push(findStaff);
		// 2 ��ѯ���в���
		List<CrmDepartment> allDepartment = departmentService.findAll();
		// * jspҳ��ͨ����key�����
		ActionContext.getContext().getValueStack().set("allDepartment", allDepartment);

		return "editUI";

	}
	
	/**
	 * �༭
	 * @return
	 */
	public String edit(){
		this.staffService.updateStaff(staff);
		return "edit";
	}
}
