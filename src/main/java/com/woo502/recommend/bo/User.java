package com.woo502.recommend.bo;

import java.util.Date;

import com.woo502.recommend.common.mybatis.BaseDo;

public class User extends BaseDo {
    private Integer userid;

    private String mobile;

    private String realname;

    private String nickname;

    private Byte sex;

    private String country;

    private String province;

    private String city;

    private String wxmpopenid;

    private String wxminiopenid;

    private String wxopenopenid;

    private String wxunionid;

    private Byte wxmpsubscribe;

    private String wxprofileimg;

    private String personalimg;

    private Byte member;

    private Date memberexpire;

    private Integer referee;

    private Byte source;

    private Integer channel;

    private Date createtime;

    private Date lasttime;

    private Byte discard;

    private String remark;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getWxmpopenid() {
        return wxmpopenid;
    }

    public void setWxmpopenid(String wxmpopenid) {
        this.wxmpopenid = wxmpopenid == null ? null : wxmpopenid.trim();
    }

    public String getWxminiopenid() {
        return wxminiopenid;
    }

    public void setWxminiopenid(String wxminiopenid) {
        this.wxminiopenid = wxminiopenid == null ? null : wxminiopenid.trim();
    }

    public String getWxopenopenid() {
        return wxopenopenid;
    }

    public void setWxopenopenid(String wxopenopenid) {
        this.wxopenopenid = wxopenopenid == null ? null : wxopenopenid.trim();
    }

    public String getWxunionid() {
        return wxunionid;
    }

    public void setWxunionid(String wxunionid) {
        this.wxunionid = wxunionid == null ? null : wxunionid.trim();
    }

    public Byte getWxmpsubscribe() {
        return wxmpsubscribe;
    }

    public void setWxmpsubscribe(Byte wxmpsubscribe) {
        this.wxmpsubscribe = wxmpsubscribe;
    }

    public String getWxprofileimg() {
        return wxprofileimg;
    }

    public void setWxprofileimg(String wxprofileimg) {
        this.wxprofileimg = wxprofileimg == null ? null : wxprofileimg.trim();
    }

    public String getPersonalimg() {
        return personalimg;
    }

    public void setPersonalimg(String personalimg) {
        this.personalimg = personalimg == null ? null : personalimg.trim();
    }

    public Byte getMember() {
        return member;
    }

    public void setMember(Byte member) {
        this.member = member;
    }

    public Date getMemberexpire() {
        return memberexpire;
    }

    public void setMemberexpire(Date memberexpire) {
        this.memberexpire = memberexpire;
    }

    public Integer getReferee() {
        return referee;
    }

    public void setReferee(Integer referee) {
        this.referee = referee;
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
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