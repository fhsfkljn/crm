package com.chao.crm.department.service.impl;

import java.util.List;

import com.chao.crm.department.dao.DepartmentDao;
import com.chao.crm.department.domain.CrmDepartment;
import com.chao.crm.department.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public List<CrmDepartment> findAll() {
		return departmentDao.findAll();
	}

}
