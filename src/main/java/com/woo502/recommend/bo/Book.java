package com.woo502.recommend.bo;

import java.util.Date;

import com.woo502.recommend.common.mybatis.BaseDo;

public class Book extends BaseDo {
    private Integer bookid;

    private String bookname;

    private Integer imgresourceid;

    private Integer audioresourceid;

    private Byte screen;

    private Byte publish;

    private Date publishtime;

    private Integer amount;

    private Byte member;

    private Byte lang;

    private Byte isread;

    private Integer createuser;

    private Integer outerbookid;

    private Byte editvs;

    private Date createtime;

    private Date lasttime;

    private Byte discard;

    private String remark;
    
    private Integer tag;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public Integer getImgresourceid() {
        return imgresourceid;
    }

    public void setImgresourceid(Integer imgresourceid) {
        this.imgresourceid = imgresourceid;
    }

    public Integer getAudioresourceid() {
        return audioresourceid;
    }

    public void setAudioresourceid(Integer audioresourceid) {
        this.audioresourceid = audioresourceid;
    }

    public Byte getScreen() {
        return screen;
    }

    public void setScreen(Byte screen) {
        this.screen = screen;
    }

    public Byte getPublish() {
        return publish;
    }

    public void setPublish(Byte publish) {
        this.publish = publish;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Byte getMember() {
        return member;
    }

    public void setMember(Byte member) {
        this.member = member;
    }

    public Byte getLang() {
        return lang;
    }

    public void setLang(Byte lang) {
        this.lang = lang;
    }

    public Byte getIsread() {
        return isread;
    }

    public void setIsread(Byte isread) {
        this.isread = isread;
    }

    public Integer getCreateuser() {
        return createuser;
    }

    public void setCreateuser(Integer createuser) {
        this.createuser = createuser;
    }

    public Integer getOuterbookid() {
        return outerbookid;
    }

    public void setOuterbookid(Integer outerbookid) {
        this.outerbookid = outerbookid;
    }

    public Byte getEditvs() {
        return editvs;
    }

    public void setEditvs(Byte editvs) {
        this.editvs = editvs;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public Byte getDiscard() {
        return discard;
    }

    public void setDiscard(Byte discard) {
        this.discard = discard;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public Integer getTag() {
		return tag == null ? 0 : tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}
}