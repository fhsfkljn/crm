package com.chao.crm.classes.service;

import java.util.List;

import com.chao.crm.classes.domain.CrmClasses;

public interface ClassesService {
	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<CrmClasses> findAll();

	/**
	 * 通过id查询详情
	 * 
	 * @param classesId
	 * @return
	 */
	public CrmClasses findById(String classesId);

	/**
	 * 更新上传
	 * 
	 * @param model
	 */
	public void updateUpload(CrmClasses model);
}
