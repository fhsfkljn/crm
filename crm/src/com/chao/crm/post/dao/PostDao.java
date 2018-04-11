package com.chao.crm.post.dao;

import java.util.List;

import com.chao.crm.department.domain.CrmDepartment;
import com.chao.crm.post.domain.CrmPost;

public interface PostDao {
	/**
	 * 查询指定部门的所有职务
	 * 
	 * @param department
	 * @return
	 */
	public List<CrmPost> findAll(CrmDepartment department);
}
