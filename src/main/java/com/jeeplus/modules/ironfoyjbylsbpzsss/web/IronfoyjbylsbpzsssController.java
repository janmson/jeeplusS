/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzsss.web;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
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
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.ironfodoctitle.service.IronfoDocTitleService;
import com.jeeplus.modules.ironfoyjbylsbpzsss.entity.Ironfoyjbylsbpzsss;
import com.jeeplus.modules.ironfoyjbylsbpzsss.service.IronfoyjbylsbpzsssService;
import com.jeeplus.modules.ironfoyjbylsbpzwkfck.entity.Ironfoyjbylsbpzwkfck;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.jeeplus.modules.tools.utils.EnumUtils;
import com.jeeplus.modules.tools.utils.GetSetMethod;
import com.jeeplus.modules.tools.utils.EnumUtils.IRONFOWKFCK;
import com.jeeplus.modules.tools.utils.EnumUtils.IRONFOWKSSS;

/**
 * 手术室Controller
 * @author mikesun
 * @version 2018-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzsss/ironfoyjbylsbpzsss")
public class IronfoyjbylsbpzsssController extends BaseController {

	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@Autowired
	private IronfoyjbylsbpzsssService ironfoyjbylsbpzsssService;
	
	@ModelAttribute
	public Ironfoyjbylsbpzsss get(@RequestParam(required=false) String id) {
		Ironfoyjbylsbpzsss entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoyjbylsbpzsssService.get(id);
		}
		if (entity == null){
			entity = new Ironfoyjbylsbpzsss();
		}
		return entity;
	}
	
	/**
	 * 手术室列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzsss:ironfoyjbylsbpzsss:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfoyjbylsbpzsss ironfoyjbylsbpzsss, HttpServletRequest request, HttpServletResponse response, Model model) {
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println(obj.getId());
		
		
		
		
		
		Map<String,Object> listData = new HashMap<String,Object>();
//		List<Object> listData = new ArrayList<Object>();
		Map<String,Object> datas = null;
		
		IronfoDocTitle title =null;
		try {
			title = IronfoDocTitle.class.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		title.setRemarks(obj.getId());
		List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
		
		if(docList.size()>0) {
			

			ironfoyjbylsbpzsss.setDoc_id(docList.get(0).getId().toString());
			List<Ironfoyjbylsbpzsss> data = ironfoyjbylsbpzsssService.queryForList(ironfoyjbylsbpzsss);
		
			listData.put("doc_id", docList.get(0).getId().toString());
			for(Ironfoyjbylsbpzsss room :data) {
				
				datas = new TreeMap<String,Object>();
//				datas.put("doc_id", data.get(0).getDoc_id());
				if("----".trim()==room.getId().trim()||"----".trim().equals(room.getId().trim())) {
					datas.put(EnumUtils.IRONFOWKSSS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", "");
				}else{
					datas.put(EnumUtils.IRONFOWKSSS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", room.getId());
				}
				
				if("----".trim()==room.getPp().trim()||"----".trim().equals(room.getPp().trim())) {
					datas.put(EnumUtils.IRONFOWKSSS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", "");
				}else {
					datas.put(EnumUtils.IRONFOWKSSS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", room.getPp());
				}
				
				if("----".trim()==room.getSbjg().trim()||"----".trim().equals(room.getSbjg().trim())) {
					datas.put(EnumUtils.IRONFOWKSSS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", "");
				}else {
					datas.put(EnumUtils.IRONFOWKSSS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", room.getSbjg());

				}
				
				if("----".trim() == room.getSl().trim()||"----".trim().equals(room.getSl().trim())) {
					datas.put(EnumUtils.IRONFOWKSSS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", "");
				}else {
					datas.put(EnumUtils.IRONFOWKSSS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", room.getSl());

				}
				
				if("----".trim()==room.getXh().trim()||"----".trim().equals(room.getXh().trim())) {
					datas.put(EnumUtils.IRONFOWKSSS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", "");
				}else {
					datas.put(EnumUtils.IRONFOWKSSS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", room.getXh());
				}
				
				if("----".trim()==room.getTrsynf().trim()||"----".trim().equals(room.getTrsynf().trim())) {
					datas.put(EnumUtils.IRONFOWKSSS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_trsynf", "");
				}else {
					datas.put(EnumUtils.IRONFOWKSSS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_trsynf", room.getTrsynf());
				}
				
				listData.put(EnumUtils.IRONFOWKSSS.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase(), datas);
				
			}
			
			
			
			
			
		}else {
			

			for(IRONFOWKSSS jz :EnumUtils.IRONFOWKSSS.values()) {
				datas = new TreeMap<String,Object>();
				datas.put(jz.toString().toLowerCase()+"_id", "");
				datas.put(jz.toString().toLowerCase()+"_sbmc", "");
				datas.put(jz.toString().toLowerCase()+"_pp", "");
				datas.put(jz.toString().toLowerCase()+"_xh", "");
				datas.put(jz.toString().toLowerCase()+"_sl", "");
				datas.put(jz.toString().toLowerCase()+"_sbjg", "");
				datas.put(jz.toString().toLowerCase()+"_trsynf", "");
//				listData.add(datas);
				listData.put(jz.toString().toLowerCase(), datas);
			}
			
			
		}
		
		
		
		
		
		request.setAttribute("data", listData);
		model.addAttribute("data", listData);
		
		
		
		return "modules/ironfoyjbylsbpzsss/ironfoyjbylsbpzsssList";
	}

	/**
	 * 查看，增加，编辑手术室表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzsss:ironfoyjbylsbpzsss:view","ironfoyjbylsbpzsss:ironfoyjbylsbpzsss:add","ironfoyjbylsbpzsss:ironfoyjbylsbpzsss:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfoyjbylsbpzsss ironfoyjbylsbpzsss, Model model) {
		model.addAttribute("ironfoyjbylsbpzsss", ironfoyjbylsbpzsss);
		return "modules/ironfoyjbylsbpzsss/ironfoyjbylsbpzsssForm";
	}

	/**
	 * 保存手术室
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzsss:ironfoyjbylsbpzsss:add","ironfoyjbylsbpzsss:ironfoyjbylsbpzsss:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfoyjbylsbpzsss ironfoyjbylsbpzsss, Model model, RedirectAttributes redirectAttributes) throws Exception{

		
		
		 String[] SBMC = new String[] {"cxbxxj",
				 "fqjxt","gqjxt","csd","ssxwj",
				 "xqfxy","csbzdy","kshj","dcsjhy","ssdt",
				 "zhssc","wyd","gpdd","yzhxj",
				 "ccy","ssdjc","cc","mzsdjcy","hxmzj","mzbb","qtqzm"};
		 
		 
		 
		 
		    boolean isnull=false;
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
			
			
			
			Subject subject = SecurityUtils.getSubject();  
			Principal obj = (Principal) subject.getPrincipal();
			
			System.out.println(obj.getId());
			
			Map<String,Object> map = new  TreeMap<String,Object>();
			String data = request.getParameter("datas");
			String[] ironfoyjbylsbpzssss = data.split(";");
			
			
			String docId = "";
			for(int i=0;i<ironfoyjbylsbpzssss.length;i++) {
					map.put(ironfoyjbylsbpzssss[i].toString().split(":")[0].toString(),ironfoyjbylsbpzssss[i].toString().split(":")[1].toString());
					if("docId" == ironfoyjbylsbpzssss[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(ironfoyjbylsbpzssss[i].toString().trim().split(":")[0].toString().trim())) {
						docId = ironfoyjbylsbpzssss[i].toString().split(":")[1].toString();
					}
			}
			
			
			if(docId.toString().trim() == null || "".equals(docId.toString().trim())) {
	 			isnull = false;
	 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
	 			title.setRemarks(obj.getId());
	 			
	 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
	 			docId= docList.get(0).getId().toString();
	 			
			}else {
				
				ironfoyjbylsbpzsss.setDoc_id(docId);
				List<Ironfoyjbylsbpzsss> ironfoList = ironfoyjbylsbpzsssService.queryForList(ironfoyjbylsbpzsss);
				if(ironfoList.size()>0) {
					isnull = true;
				}else {
					isnull = false;
				}
				
			}
			
			
			
			Ironfoyjbylsbpzsss ironfoyjbylsbpzsss_data=null;
			
			if(isnull == false) {
				//更新
				int i=1;
				ironfoyjbylsbpzsss_data = new Ironfoyjbylsbpzsss();
				for(int j=0;j<SBMC.length;j++) {
					
					for(Map.Entry<String, Object> entry :map.entrySet()) {
						if(SBMC[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||SBMC[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
							if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
								
							}else {
								
									Method m = GetSetMethod.getSetMethod(Ironfoyjbylsbpzsss.class,entry.getKey().toString().trim().split("_")[1].toString());
									m.invoke(ironfoyjbylsbpzsss_data, new Object[]{entry.getValue()} );
									i++;
									if(i==7) {
										ironfoyjbylsbpzsss_data.setDoc_id(docId); 
										ironfoyjbylsbpzsssService.save(ironfoyjbylsbpzsss_data);//保存
										i = 1;
										ironfoyjbylsbpzsss_data = new Ironfoyjbylsbpzsss();
								}	
							}	
						}	
					}	
				}	
				
				
			}else if(isnull == true){
				
				
				//更新
				int i=1;
				ironfoyjbylsbpzsss_data = new Ironfoyjbylsbpzsss();
				for(int j=0;j<SBMC.length;j++) {
					
					for(Map.Entry<String, Object> entry :map.entrySet()) {
						if(SBMC[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||SBMC[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
							if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
								ironfoyjbylsbpzsss_data.setId(entry.getValue().toString());
							}else {
								
									Method m = GetSetMethod.getSetMethod(Ironfoyjbylsbpzsss.class,entry.getKey().toString().trim().split("_")[1].toString());
									m.invoke(ironfoyjbylsbpzsss_data, new Object[]{entry.getValue()} );
									i++;
									if(i==7) {
										ironfoyjbylsbpzsss_data.setDoc_id(docId); 
										ironfoyjbylsbpzsssService.updateIronfo(ironfoyjbylsbpzsss_data);//保存
										i = 1;
										ironfoyjbylsbpzsss_data = new Ironfoyjbylsbpzsss();
								}	
							}	
						}	
					}	
				}	
					
				
			}
		
			
		 
		
		
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzsss/ironfoyjbylsbpzsss/?repage";
	}
	
	/**
	 * 删除手术室
	 */
	@RequiresPermissions("ironfoyjbylsbpzsss:ironfoyjbylsbpzsss:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfoyjbylsbpzsss ironfoyjbylsbpzsss, RedirectAttributes redirectAttributes) {
		ironfoyjbylsbpzsssService.delete(ironfoyjbylsbpzsss);
		addMessage(redirectAttributes, "删除手术室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzsss/ironfoyjbylsbpzsss/?repage";
	}
	
	/**
	 * 批量删除手术室
	 */
	@RequiresPermissions("ironfoyjbylsbpzsss:ironfoyjbylsbpzsss:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoyjbylsbpzsssService.delete(ironfoyjbylsbpzsssService.get(id));
		}
		addMessage(redirectAttributes, "删除手术室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzsss/ironfoyjbylsbpzsss/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpzsss:ironfoyjbylsbpzsss:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfoyjbylsbpzsss ironfoyjbylsbpzsss, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "手术室"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfoyjbylsbpzsss> page = ironfoyjbylsbpzsssService.findPage(new Page<Ironfoyjbylsbpzsss>(request, response, -1), ironfoyjbylsbpzsss);
    		new ExportExcel("手术室", Ironfoyjbylsbpzsss.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出手术室记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzsss/ironfoyjbylsbpzsss/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpzsss:ironfoyjbylsbpzsss:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfoyjbylsbpzsss> list = ei.getDataList(Ironfoyjbylsbpzsss.class);
			for (Ironfoyjbylsbpzsss ironfoyjbylsbpzsss : list){
				try{
					ironfoyjbylsbpzsssService.save(ironfoyjbylsbpzsss);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条手术室记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条手术室记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入手术室失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzsss/ironfoyjbylsbpzsss/?repage";
    }
	
	/**
	 * 下载导入手术室数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzsss:ironfoyjbylsbpzsss:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "手术室数据导入模板.xlsx";
    		List<Ironfoyjbylsbpzsss> list = Lists.newArrayList(); 
    		new ExportExcel("手术室数据", Ironfoyjbylsbpzsss.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzsss/ironfoyjbylsbpzsss/?repage";
    }
	
	
	

}