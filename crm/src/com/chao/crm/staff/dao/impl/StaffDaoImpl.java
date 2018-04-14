package com.chao.crm.staff.dao.impl;

import java.util.List;

import com.chao.crm.base.impl.BaseDaoImpl;
import com.chao.crm.staff.dao.StaffDao;
import com.chao.crm.staff.domain.CrmStaff;

public class StaffDaoImpl extends BaseDaoImpl<CrmStaff> implements StaffDao {

	@Override
	public CrmStaff find(String loginName, String loginPwd) {
		@SuppressWarnings("unchecked")
		List<CrmStaff> allStaff = this.getHibernateTemplate().find("from CrmStaff where loginName=? and loginPwd = ?", loginName,loginPwd);
		if(allStaff.size() == 1){
			return allStaff.get(0);
		} 
		return null;
	}
	
	

}
