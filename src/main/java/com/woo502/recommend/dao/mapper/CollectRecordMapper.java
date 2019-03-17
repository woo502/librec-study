package com.woo502.recommend.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.woo502.recommend.bo.CollectRecord;
import com.woo502.recommend.common.mybatis.BaseMapper;

public interface CollectRecordMapper extends BaseMapper {
    @Select({
        "select",
        "collectId, bookId, userId, bookName, imgResourceId, createTime, lastTime, discard, ",
        "remark",
        "from t_collect_record",
        "where discard = 0",
        "order by userId"
    })
    @Results({
        @Result(column="collectId", property="collectid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="bookId", property="bookid", jdbcType=JdbcType.INTEGER),
        @Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="bookName", property="bookname", jdbcType=JdbcType.VARCHAR),
        @Result(column="imgResourceId", property="imgresourceid", jdbcType=JdbcType.INTEGER),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastTime", property="lasttime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="discard", property="discard", jdbcType=JdbcType.TINYINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<CollectRecord> findAll();
}