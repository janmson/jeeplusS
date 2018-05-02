/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivedqzygdfsreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 供电方式Entity
 * @author anti_magina
 * @version 2018-04-23
 */
public class IronfofivedqzygdfsReport extends DataEntity<IronfofivedqzygdfsReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表
	private String dwdl;		// 电网单路
	private String dwsl;		// 电网双路
	private String ryfdj;		// 燃油发电机
	private String upszz;		// UPS装置
	private User duser;
	private IronfoDocTitle ironfoDocTitle;
	public User getDuser() {
		return duser;
	}

	public void setDuser(User duser) {
		this.duser = duser;
	}

	public IronfoDocTitle getIronfoDocTitle() {
		return ironfoDocTitle;
	}

	public void setIronfoDocTitle(IronfoDocTitle ironfoDocTitle) {
		this.ironfoDocTitle = ironfoDocTitle;
	}

	public IronfofivedqzygdfsReport() {
		super();
	}

	public IronfofivedqzygdfsReport(String id){
		super(id);
	}

	//@ExcelField(title="主表", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
	@ExcelField(title="电网单路", dictType="", align=2, sort=8)
	public String getDwdl() {
		return dwdl;
	}

	public void setDwdl(String dwdl) {
		this.dwdl = dwdl;
	}
	
	@ExcelField(title="电网双路", dictType="", align=2, sort=9)
	public String getDwsl() {
		return dwsl;
	}

	public void setDwsl(String dwsl) {
		this.dwsl = dwsl;
	}
	
	@ExcelField(title="燃油发电机", dictType="", align=2, sort=10)
	public String getRyfdj() {
		return ryfdj;
	}

	public void setRyfdj(String ryfdj) {
		this.ryfdj = ryfdj;
	}
	
	@ExcelField(title="UPS装置", dictType="", align=2, sort=11)
	public String getUpszz() {
		return upszz;
	}

	public void setUpszz(String upszz) {
		this.upszz = upszz;
	}
	
}