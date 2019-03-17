package com.woo502.recommend.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.woo502.recommend.bo.User;
import com.woo502.recommend.common.mybatis.BaseMapper;

public interface UserMapper extends BaseMapper {
    @Select({
        "select",
        "userId, mobile, realName, nickName, sex, country, province, city, wxMpOpenId, ",
        "wxMiniOpenId, wxOpenOpenId, wxUnionId, wxMpSubscribe, wxProfileImg, personalImg, ",
        "member, memberExpire, referee, source, channel, createTime, lastTime, discard, ",
        "remark",
        "from t_user",
        "where discard = 0",
        "order by userId"
//        ,"limit 100"
    })
    @Results({
        @Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="realName", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickName", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.TINYINT),
        @Result(column="country", property="country", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="wxMpOpenId", property="wxmpopenid", jdbcType=JdbcType.VARCHAR),
        @Result(column="wxMiniOpenId", property="wxminiopenid", jdbcType=JdbcType.VARCHAR),
        @Result(column="wxOpenOpenId", property="wxopenopenid", jdbcType=JdbcType.VARCHAR),
        @Result(column="wxUnionId", property="wxunionid", jdbcType=JdbcType.VARCHAR),
        @Result(column="wxMpSubscribe", property="wxmpsubscribe", jdbcType=JdbcType.TINYINT),
        @Result(column="wxProfileImg", property="wxprofileimg", jdbcType=JdbcType.VARCHAR),
        @Result(column="personalImg", property="personalimg", jdbcType=JdbcType.VARCHAR),
        @Result(column="member", property="member", jdbcType=JdbcType.TINYINT),
        @Result(column="memberExpire", property="memberexpire", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="referee", property="referee", jdbcType=JdbcType.INTEGER),
        @Result(column="source", property="source", jdbcType=JdbcType.TINYINT),
        @Result(column="channel", property="channel", jdbcType=JdbcType.INTEGER),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastTime", property="lasttime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="discard", property="discard", jdbcType=JdbcType.TINYINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<User> findAll();
}