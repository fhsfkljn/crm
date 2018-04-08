package com.chao.crm.staff.web.action;

import com.chao.crm.staff.domain.CrmStaff;
import com.chao.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff> {

	// 封装数据
	private CrmStaff staff = new CrmStaff();

	@Override
	public CrmStaff getModel() {
		return staff;
	}

	// 默认按照名称注入
	private StaffService staffService;

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	// ----------------------------------------------

	/**
	 * 员工登录
	 * 
	 * @return
	 */
	public String login() {
		// 1 查询员工
		CrmStaff findStaff = staffService.login(staff);
		// 2 是否成功
		if (findStaff != null) {
			// 成功
			// 3.1 session作用域保存数据
			ActionContext.getContext().getSession().put("loginStaff", findStaff);
			// 3.2 重定向首页 -- xml配置
			return "success";
		}
		// 4 不成功
		this.addFieldError("", "用户名与密码不匹配");
		// * 请求转发显示
		return "login";
	}
	
	/**
	 * 显示首页
	 * @return
	 */
	public String home(){
		return "home";
	}

}
