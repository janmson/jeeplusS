/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sysrole.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.modules.sysrole.entity.SysRole;
import com.jeeplus.modules.sysrole.service.SysRoleService;

/**
 * 角色管理Controller
 * @author mikesun
 * @version 2017-10-12
 */
@Controller
@RequestMapping(value = "${adminPath}/sysrole/sysRole")
public class SysRoleController extends BaseController {

	@Autowired
	private SysRoleService sysRoleService;
	
	@ModelAttribute
	public SysRole get(@RequestParam(required=false) String id) {
		SysRole entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysRoleService.get(id);
		}
		if (entity == null){
			entity = new SysRole();
		}
		return entity;
	}
	
	/**
	 * 角色管理列表页面
	 */
	@RequiresPermissions("sysrole:sysRole:list")
	@RequestMapping(value = {"list", ""})
	public String list(SysRole sysRole, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysRole> page = sysRoleService.findPage(new Page<SysRole>(request, response), sysRole); 
		model.addAttribute("page", page);
		return "modules/sysrole/sysRoleList";
	}

	/**
	 * 查看，增加，编辑角色管理表单页面
	 */
	@RequiresPermissions(value={"sysrole:sysRole:view","sysrole:sysRole:add","sysrole:sysRole:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(SysRole sysRole, Model model) {
		model.addAttribute("sysRole", sysRole);
		return "modules/sysrole/sysRoleForm";
	}

	/**
	 * 保存角色管理
	 */
	@RequiresPermissions(value={"sysrole:sysRole:add","sysrole:sysRole:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(SysRole sysRole, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, sysRole)){
			return form(sysRole, model);
		}
		if(!sysRole.getIsNewRecord()){//编辑表单保存
			SysRole t = sysRoleService.get(sysRole.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(sysRole, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			sysRoleService.save(t);//保存
		}else{//新增表单保存
			sysRoleService.save(sysRole);//保存
		}
		addMessage(redirectAttributes, "保存角色管理成功");
		return "redirect:"+Global.getAdminPath()+"/sysrole/sysRole/?repage";
	}
	
	/**
	 * 删除角色管理
	 */
	@RequiresPermissions("sysrole:sysRole:del")
	@RequestMapping(value = "delete")
	public String delete(SysRole sysRole, RedirectAttributes redirectAttributes) {
		sysRoleService.delete(sysRole);
		addMessage(redirectAttributes, "删除角色管理成功");
		return "redirect:"+Global.getAdminPath()+"/sysrole/sysRole/?repage";
	}
	
	/**
	 * 批量删除角色管理
	 */
	@RequiresPermissions("sysrole:sysRole:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			sysRoleService.delete(sysRoleService.get(id));
		}
		addMessage(redirectAttributes, "删除角色管理成功");
		return "redirect:"+Global.getAdminPath()+"/sysrole/sysRole/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("sysrole:sysRole:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(SysRole sysRole, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "角色管理"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<SysRole> page = sysRoleService.findPage(new Page<SysRole>(request, response, -1), sysRole);
    		new ExportExcel("角色管理", SysRole.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出角色管理记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/sysrole/sysRole/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("sysrole:sysRole:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<SysRole> list = ei.getDataList(SysRole.class);
			for (SysRole sysRole : list){
				try{
					sysRoleService.save(sysRole);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条角色管理记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条角色管理记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入角色管理失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/sysrole/sysRole/?repage";
    }
	
	/**
	 * 下载导入角色管理数据模板
	 */
	@RequiresPermissions("sysrole:sysRole:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "角色管理数据导入模板.xlsx";
    		List<SysRole> list = Lists.newArrayList(); 
    		new ExportExcel("角色管理数据", SysRole.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/sysrole/sysRole/?repage";
    }
	
	
	

}