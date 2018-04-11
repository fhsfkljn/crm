package com.chao.crm.post.web.action;

import java.io.IOException;
import java.util.List;

import javax.json.JsonArray;

import org.apache.struts2.ServletActionContext;

import com.chao.crm.post.domain.CrmPost;
import com.chao.crm.post.service.PostService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class PostAction extends ActionSupport implements ModelDriven<CrmPost> {

	private CrmPost post = new CrmPost();

	@Override
	public CrmPost getModel() {
		// TODO Auto-generated method stub
		return post;
	}

	// service
	private PostService postService;

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	// ----------------------------------------------------------

	/**
	 * ajax ͨ������ ����ѯ���е�ְ��
	 * 
	 * @return
	 * @throws IOException
	 */
	public String findAllWithDepartment() throws IOException {
		// 1 ��ѯ
		List<CrmPost> allPost = this.postService.findAll(post.getDepartment());

		// 2 ��java���� ת�� json����
		// 2.1 �ų�����Ҫ����
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "department", "staffSet" });
		// 2.2 ת��
		String jsonData = JSONArray.fromObject(allPost, jsonConfig).toString();

		// 3 ��json���ݷ��͸������
		// 3.1 ��Ӧ��������
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		// 3.2 ����
		ServletActionContext.getResponse().getWriter().print(jsonData);
		
		return "none";
	}

}