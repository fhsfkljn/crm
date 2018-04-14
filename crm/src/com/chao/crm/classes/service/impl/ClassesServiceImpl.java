package com.chao.crm.classes.service.impl;

import java.util.List;

import com.chao.crm.classes.dao.ClassesDao;
import com.chao.crm.classes.domain.CrmClasses;
import com.chao.crm.classes.service.ClassesService;

public class ClassesServiceImpl implements ClassesService {
	private ClassesDao classesDao;

	public void setClassesDao(ClassesDao classesDao) {
		this.classesDao = classesDao;
	}

	@Override
	public List<CrmClasses> findAll() {
		return classesDao.findAll();
	}

	@Override
	public CrmClasses findById(String classesId) {
		return classesDao.findById(classesId);
	}

	@Override
	public void updateUpload(CrmClasses classes) {
		// 1先查询，2再更新。快照和一级缓存
		CrmClasses findClass = this.classesDao.findById(classes.getClassId());
		findClass.setUploadFilename(classes.getUploadFilename());
		findClass.setUploadPath(classes.getUploadPath());
		findClass.setUploadTime(classes.getUploadTime());
	}
}
