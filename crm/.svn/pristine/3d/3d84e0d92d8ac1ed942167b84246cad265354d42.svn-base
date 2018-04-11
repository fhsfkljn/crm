package com.chao.crm.department.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.chao.crm.department.dao.DepartmentDao;
import com.chao.crm.department.domain.CrmDepartment;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public List<CrmDepartment> findAll() {
		return this.getHibernateTemplate().find("from CrmDepartment");
	}

}
