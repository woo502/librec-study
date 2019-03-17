package com.woo502.recommend.bo;

import java.util.Date;

import com.woo502.recommend.common.mybatis.BaseDo;

public class BookStatistic extends BaseDo {
    private Date datestr;

    private Integer bookid;

    private String bookname;

    private Integer read;

    private Integer readcomplete;

    private Integer forward;

    private Integer collect;

    private Integer listen;

    private Integer readtotal;

    private Integer readcompletetotal;

    private Integer forwardtotal;

    private Integer collecttotal;

    private Integer listentotal;

    private Date createtime;

    private Date lasttime;

    public Date getDatestr() {
        return datestr;
    }

    public void setDatestr(Date datestr) {
        this.datestr = datestr;
    }

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

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }

    public Integer getReadcomplete() {
        return readcomplete;
    }

    public void setReadcomplete(Integer readcomplete) {
        this.readcomplete = readcomplete;
    }

    public Integer getForward() {
        return forward;
    }

    public void setForward(Integer forward) {
        this.forward = forward;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Integer getListen() {
        return listen;
    }

    public void setListen(Integer listen) {
        this.listen = listen;
    }

    public Integer getReadtotal() {
        return readtotal;
    }

    public void setReadtotal(Integer readtotal) {
        this.readtotal = readtotal;
    }

    public Integer getReadcompletetotal() {
        return readcompletetotal;
    }

    public void setReadcompletetotal(Integer readcompletetotal) {
        this.readcompletetotal = readcompletetotal;
    }

    public Integer getForwardtotal() {
        return forwardtotal;
    }

    public void setForwardtotal(Integer forwardtotal) {
        this.forwardtotal = forwardtotal;
    }

    public Integer getCollecttotal() {
        return collecttotal;
    }

    public void setCollecttotal(Integer collecttotal) {
        this.collecttotal = collecttotal;
    }

    public Integer getListentotal() {
        return listentotal;
    }

    public void setListentotal(Integer listentotal) {
        this.listentotal = listentotal;
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
}