package com.woo502.recommend.bo;

import java.util.Date;

import com.woo502.recommend.common.mybatis.BaseDo;

public class ReadRecord extends BaseDo {
    private Integer readid;

    private Integer bookid;

    private Integer userid;

    private Byte type;

    private String bookname;

    private Integer imgresourceid;

    private Date createtime;

    private Date lasttime;

    private Byte discard;

    private String remark;

    public Integer getReadid() {
        return readid;
    }

    public void setReadid(Integer readid) {
        this.readid = readid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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
}