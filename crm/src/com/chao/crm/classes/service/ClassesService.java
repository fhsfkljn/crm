package com.chao.crm.classes.service;

import java.util.List;

import com.chao.crm.classes.domain.CrmClasses;

public interface ClassesService {
	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public List<CrmClasses> findAll();

	/**
	 * ͨ��id��ѯ����
	 * 
	 * @param classesId
	 * @return
	 */
	public CrmClasses findById(String classesId);

	/**
	 * �����ϴ�
	 * 
	 * @param model
	 */
	public void updateUpload(CrmClasses model);
}
