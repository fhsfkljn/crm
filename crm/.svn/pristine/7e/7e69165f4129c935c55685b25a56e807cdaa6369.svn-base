package com.chao.crm.classes.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.chao.crm.base.BaseAction;
import com.chao.crm.classes.domain.CrmClasses;
import com.chao.crm.utils.MyStringUtils;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class ClassesAction extends BaseAction<CrmClasses> {
	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public String findAll() {
		List<CrmClasses> allClasses = this.getClassesService().findAll();
		this.set("allClasses", allClasses);
		return "findAll";
	}

	/**
	 * 显示上传表单
	 * 
	 * @return
	 */
	public String uploadUI() {
		CrmClasses findClasses = this.getClassesService().findById(this.getModel().getClassId());
		// 将查询的数据压入到指定
		this.push(findClasses);

		return "uploadUI";
	}

	private File schedule; // 上传内容
	private String scheduleFileName; // 上传文件名
	private String scheduleContentType; // 上传类型

	public void setSchedule(File schedule) {
		this.schedule = schedule;
	}

	public void setScheduleFileName(String scheduleFileName) {
		this.scheduleFileName = scheduleFileName;
	}

	public void setScheduleContentType(String scheduleContentType) {
		this.scheduleContentType = scheduleContentType;
	}

	/**
	 * 文件上传
	 * 
	 * @return
	 * @throws IOException
	 */
	@InputConfig(resultName = "uploadInput")
	public String upload() throws IOException {

		// 1 将课本 保存 硬盘 。
		// 1.1 位置：tomcat.../WEB-INF/upload/....
		String parentDir = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
		System.out.println("---------------");
		System.out.println(parentDir);
		// 1.2 文件名 随机数，且没有扩展名
		String fileName = MyStringUtils.getUUID();
		// 1.3 保存
		FileUtils.copyFile(schedule, new File(parentDir, fileName));

		// 2 更新
		this.getModel().setUploadTime(new Date());
		this.getModel().setUploadPath("/WEB-INF/upload/" + fileName);
		this.getModel().setUploadFilename(scheduleFileName);

		this.getClassesService().updateUpload(this.getModel());

		return "upload";
	}

	// 注意：在给InputSteam指定名称时，不能使用in
	private InputStream inputStream;
	// 创建一个文件名的属性
	private String filename;

	public String download() throws FileNotFoundException, UnsupportedEncodingException {
		
		CrmClasses findClasses = this.getClassesService().findById(this.getModel().getClassId());
		String pathString = findClasses.getUploadPath();
		
		// 1.找到文件的存储路径
		String filePath = ServletActionContext.getServletContext().getRealPath(pathString);
		// 2.把文件读到一个InputStream中
		inputStream = new FileInputStream(filePath);

		// 在返回之前，给filename赋值
		filename = findClasses.getUploadFilename();
//		filename = URLEncoder.encode(filename,"UTF-8");
		

		// 3.返回一个成功
		return "downloadSuccess";
		
		// 4.由一个叫做stream的结果类型为我们把剩下的事情做完。
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
