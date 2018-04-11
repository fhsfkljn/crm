package com.chao.crm.post.service.impl;

import java.util.List;

import com.chao.crm.department.domain.CrmDepartment;
import com.chao.crm.post.dao.PostDao;
import com.chao.crm.post.domain.CrmPost;
import com.chao.crm.post.service.PostService;

public class PostServiceImpl implements PostService {

	private PostDao postDao;
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	
	@Override
	public List<CrmPost> findAll(CrmDepartment department) {
		return postDao.findAll(department);
	}

}
