package com.chao.crm.staff.web.action;

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
	private StaffService staffService;

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
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
	 * @return
	 */
	public String home(){
		return "home";
	}

}
