/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiveznglyfreport.entity;


import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.sys.entity.User;

/**
 * 5.7职能管理用房Entity
 * @author anti_magina
 * @version 2018-04-23
 */
public class IronfofiveznglyfReport extends DataEntity<IronfofiveznglyfReport> {
	
	private static final long serialVersionUID = 1L;
	private String doc_id;		// 主表id
	private String gndyjzmj;		// 功能单元建筑面积（m2）
	private String yzbgs;		// 院长办公室
	private String djbgs;		// 党建办公室
	private String ywkbgs;		// 医务科办公室
	private String hlkbgs;		// 护理科办公室
	private String cwkbgs;		// 财务科办公室
	private String daglkbgs;		// 病案管理科办公室
	private String xxzx;		// 信息中心
	private String ygkbgs;		// 院感科办公室
	private String ybjskbgs;		// 医保结算科办公室
	private String hqglkbgs;		// 后勤管理科办公室
	private String dgnhys;		// 多功能会议室
	private String xyf;		// 洗衣房
	private String yycf;		// 营养厨房
	private String ylljzcjljzcj;		// 医疗垃圾暂存间-垃圾暂存间
	private String shljzcjljzcj;		// 生活垃圾暂存间-垃圾暂存间
	private String tpj;		// 太平间
	private String bpdsbpdyf;		// 变配电室-变配电用房
	private String bpdzbsbpdyf;		// 变配电值班室-变配电用房
	private String cyfdjfcyfdyf;		// 柴油发电机房-柴油发电用房
	private String ykcyfdyf;		// 油库-柴油发电用房
	private String dtjf;		// 电梯机房
	private String glfglyf;		// 锅炉房-锅炉用房
	private String glkzsglyf;		// 锅炉控制室-锅炉用房
	private String rqbjglyf;		// 燃气表间-锅炉用房
	private String lsjf;		// 冷水机房
	private String ktjf;		// 空调机房
	private String tfjf;		// 通风机房
	private String gsbf;		// 给水泵房
	private String xfbf;		// 消防泵房
	private String bjzs;		// 报警阀室
	private String xfsxj;		// 消防水箱间
	private String xfkzs;		// 消防控制室
	private String afjks;		// 安防监控室
	private String txwljf;		// 通信网络机房
	private String xxhxtjf;		// 信息化系统机房
	private String mws;		// 门卫室
	private String sntcc;		// 室内停车场
	private String qtqzm;		// 其它（请注明）
	private User duser;
	private IronfoDocTitle ironfoDocTitle;
	public IronfofiveznglyfReport() {
		super();
	}

	public IronfofiveznglyfReport(String id){
		super(id);
	}

	//@ExcelField(title="主表id", align=2, sort=7)
	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	
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

	@ExcelField(title="功能单元建筑面积（m2）", align=2, sort=8)
	public String getGndyjzmj() {
		return gndyjzmj;
	}

	public void setGndyjzmj(String gndyjzmj) {
		this.gndyjzmj = gndyjzmj;
	}
	
	@ExcelField(title="院长办公室", dictType="", align=2, sort=9)
	public String getYzbgs() {
		return yzbgs;
	}

	public void setYzbgs(String yzbgs) {
		this.yzbgs = yzbgs;
	}
	
	@ExcelField(title="党建办公室", dictType="", align=2, sort=10)
	public String getDjbgs() {
		return djbgs;
	}

	public void setDjbgs(String djbgs) {
		this.djbgs = djbgs;
	}
	
	@ExcelField(title="医务科办公室", dictType="", align=2, sort=11)
	public String getYwkbgs() {
		return ywkbgs;
	}

	public void setYwkbgs(String ywkbgs) {
		this.ywkbgs = ywkbgs;
	}
	
	@ExcelField(title="护理科办公室", dictType="", align=2, sort=12)
	public String getHlkbgs() {
		return hlkbgs;
	}

	public void setHlkbgs(String hlkbgs) {
		this.hlkbgs = hlkbgs;
	}
	
	@ExcelField(title="财务科办公室", dictType="", align=2, sort=13)
	public String getCwkbgs() {
		return cwkbgs;
	}

	public void setCwkbgs(String cwkbgs) {
		this.cwkbgs = cwkbgs;
	}
	
	@ExcelField(title="病案管理科办公室", dictType="", align=2, sort=14)
	public String getDaglkbgs() {
		return daglkbgs;
	}

	public void setDaglkbgs(String daglkbgs) {
		this.daglkbgs = daglkbgs;
	}
	
	@ExcelField(title="信息中心", dictType="", align=2, sort=15)
	public String getXxzx() {
		return xxzx;
	}

	public void setXxzx(String xxzx) {
		this.xxzx = xxzx;
	}
	
	@ExcelField(title="院感科办公室", dictType="", align=2, sort=16)
	public String getYgkbgs() {
		return ygkbgs;
	}

	public void setYgkbgs(String ygkbgs) {
		this.ygkbgs = ygkbgs;
	}
	
	@ExcelField(title="医保结算科办公室", dictType="", align=2, sort=17)
	public String getYbjskbgs() {
		return ybjskbgs;
	}

	public void setYbjskbgs(String ybjskbgs) {
		this.ybjskbgs = ybjskbgs;
	}
	
	@ExcelField(title="后勤管理科办公室", dictType="", align=2, sort=18)
	public String getHqglkbgs() {
		return hqglkbgs;
	}

	public void setHqglkbgs(String hqglkbgs) {
		this.hqglkbgs = hqglkbgs;
	}
	
	@ExcelField(title="多功能会议室", dictType="", align=2, sort=19)
	public String getDgnhys() {
		return dgnhys;
	}

	public void setDgnhys(String dgnhys) {
		this.dgnhys = dgnhys;
	}
	
	@ExcelField(title="洗衣房", dictType="", align=2, sort=20)
	public String getXyf() {
		return xyf;
	}

	public void setXyf(String xyf) {
		this.xyf = xyf;
	}
	
	@ExcelField(title="营养厨房", dictType="", align=2, sort=21)
	public String getYycf() {
		return yycf;
	}

	public void setYycf(String yycf) {
		this.yycf = yycf;
	}
	
	@ExcelField(title="医疗垃圾暂存间-垃圾暂存间", dictType="", align=2, sort=22)
	public String getYlljzcjljzcj() {
		return ylljzcjljzcj;
	}

	public void setYlljzcjljzcj(String ylljzcjljzcj) {
		this.ylljzcjljzcj = ylljzcjljzcj;
	}
	
	@ExcelField(title="生活垃圾暂存间-垃圾暂存间", dictType="", align=2, sort=23)
	public String getShljzcjljzcj() {
		return shljzcjljzcj;
	}

	public void setShljzcjljzcj(String shljzcjljzcj) {
		this.shljzcjljzcj = shljzcjljzcj;
	}
	
	@ExcelField(title="太平间", dictType="", align=2, sort=24)
	public String getTpj() {
		return tpj;
	}

	public void setTpj(String tpj) {
		this.tpj = tpj;
	}
	
	@ExcelField(title="变配电室-变配电用房", dictType="", align=2, sort=25)
	public String getBpdsbpdyf() {
		return bpdsbpdyf;
	}

	public void setBpdsbpdyf(String bpdsbpdyf) {
		this.bpdsbpdyf = bpdsbpdyf;
	}
	
	@ExcelField(title="变配电值班室-变配电用房", dictType="", align=2, sort=26)
	public String getBpdzbsbpdyf() {
		return bpdzbsbpdyf;
	}

	public void setBpdzbsbpdyf(String bpdzbsbpdyf) {
		this.bpdzbsbpdyf = bpdzbsbpdyf;
	}
	
	@ExcelField(title="柴油发电机房-柴油发电用房", dictType="", align=2, sort=27)
	public String getCyfdjfcyfdyf() {
		return cyfdjfcyfdyf;
	}

	public void setCyfdjfcyfdyf(String cyfdjfcyfdyf) {
		this.cyfdjfcyfdyf = cyfdjfcyfdyf;
	}
	
	@ExcelField(title="油库-柴油发电用房", dictType="", align=2, sort=28)
	public String getYkcyfdyf() {
		return ykcyfdyf;
	}

	public void setYkcyfdyf(String ykcyfdyf) {
		this.ykcyfdyf = ykcyfdyf;
	}
	
	@ExcelField(title="电梯机房", dictType="", align=2, sort=29)
	public String getDtjf() {
		return dtjf;
	}

	public void setDtjf(String dtjf) {
		this.dtjf = dtjf;
	}
	
	@ExcelField(title="锅炉房-锅炉用房", dictType="", align=2, sort=30)
	public String getGlfglyf() {
		return glfglyf;
	}

	public void setGlfglyf(String glfglyf) {
		this.glfglyf = glfglyf;
	}
	
	@ExcelField(title="锅炉控制室-锅炉用房", dictType="", align=2, sort=31)
	public String getGlkzsglyf() {
		return glkzsglyf;
	}

	public void setGlkzsglyf(String glkzsglyf) {
		this.glkzsglyf = glkzsglyf;
	}
	
	@ExcelField(title="燃气表间-锅炉用房", dictType="", align=2, sort=32)
	public String getRqbjglyf() {
		return rqbjglyf;
	}

	public void setRqbjglyf(String rqbjglyf) {
		this.rqbjglyf = rqbjglyf;
	}
	
	@ExcelField(title="冷水机房", dictType="", align=2, sort=33)
	public String getLsjf() {
		return lsjf;
	}

	public void setLsjf(String lsjf) {
		this.lsjf = lsjf;
	}
	
	@ExcelField(title="空调机房", dictType="", align=2, sort=34)
	public String getKtjf() {
		return ktjf;
	}

	public void setKtjf(String ktjf) {
		this.ktjf = ktjf;
	}
	
	@ExcelField(title="通风机房", dictType="", align=2, sort=35)
	public String getTfjf() {
		return tfjf;
	}

	public void setTfjf(String tfjf) {
		this.tfjf = tfjf;
	}
	
	@ExcelField(title="给水泵房", dictType="", align=2, sort=36)
	public String getGsbf() {
		return gsbf;
	}

	public void setGsbf(String gsbf) {
		this.gsbf = gsbf;
	}
	
	@ExcelField(title="消防泵房", dictType="", align=2, sort=37)
	public String getXfbf() {
		return xfbf;
	}

	public void setXfbf(String xfbf) {
		this.xfbf = xfbf;
	}
	
	@ExcelField(title="报警阀室", dictType="", align=2, sort=38)
	public String getBjzs() {
		return bjzs;
	}

	public void setBjzs(String bjzs) {
		this.bjzs = bjzs;
	}
	
	@ExcelField(title="消防水箱间", dictType="", align=2, sort=39)
	public String getXfsxj() {
		return xfsxj;
	}

	public void setXfsxj(String xfsxj) {
		this.xfsxj = xfsxj;
	}
	
	@ExcelField(title="消防控制室", dictType="", align=2, sort=40)
	public String getXfkzs() {
		return xfkzs;
	}

	public void setXfkzs(String xfkzs) {
		this.xfkzs = xfkzs;
	}
	
	@ExcelField(title="安防监控室", dictType="", align=2, sort=41)
	public String getAfjks() {
		return afjks;
	}

	public void setAfjks(String afjks) {
		this.afjks = afjks;
	}
	
	@ExcelField(title="通信网络机房", dictType="", align=2, sort=42)
	public String getTxwljf() {
		return txwljf;
	}

	public void setTxwljf(String txwljf) {
		this.txwljf = txwljf;
	}
	
	@ExcelField(title="信息化系统机房", dictType="", align=2, sort=43)
	public String getXxhxtjf() {
		return xxhxtjf;
	}

	public void setXxhxtjf(String xxhxtjf) {
		this.xxhxtjf = xxhxtjf;
	}
	
	@ExcelField(title="门卫室", dictType="", align=2, sort=44)
	public String getMws() {
		return mws;
	}

	public void setMws(String mws) {
		this.mws = mws;
	}
	
	@ExcelField(title="室内停车场", dictType="", align=2, sort=45)
	public String getSntcc() {
		return sntcc;
	}

	public void setSntcc(String sntcc) {
		this.sntcc = sntcc;
	}
	
	@ExcelField(title="其它（请注明）", align=2, sort=46)
	public String getQtqzm() {
		return qtqzm;
	}

	public void setQtqzm(String qtqzm) {
		this.qtqzm = qtqzm;
	}
	
}