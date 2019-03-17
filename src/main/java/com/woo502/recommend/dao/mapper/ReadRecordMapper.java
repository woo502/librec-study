package com.woo502.recommend.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.woo502.recommend.bo.ReadRecord;
import com.woo502.recommend.common.mybatis.BaseMapper;

public interface ReadRecordMapper extends BaseMapper {
    @Select({
        "select",
        "readId, bookId, userId, max(type) as type, bookName, imgResourceId, createTime, lastTime, ",
        "discard, remark",
        "from t_read_record",
        "where type in (1, 2) and discard = 0",
        "group by userId, bookId",
        "order by userId, bookId"
//        ,"limit 100"
    })
    @Results({
        @Result(column="readId", property="readid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="bookId", property="bookid", jdbcType=JdbcType.INTEGER),
        @Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="bookName", property="bookname", jdbcType=JdbcType.VARCHAR),
        @Result(column="imgResourceId", property="imgresourceid", jdbcType=JdbcType.INTEGER),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastTime", property="lasttime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="discard", property="discard", jdbcType=JdbcType.TINYINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ReadRecord> findAll();
}