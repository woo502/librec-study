package com.woo502.recommend.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.woo502.recommend.bo.ShareRecord;
import com.woo502.recommend.common.mybatis.BaseMapper;

public interface ShareRecordMapper extends BaseMapper {
    @Select({
        "select",
        "shareId, userId, bookId, shareType, createTime, lastTime, discard",
        "from t_share_record",
        "where bookId <> 0 and discard = 0",
        "order by userId"
//      ,"limit 100"
    })
    @Results({
        @Result(column="shareId", property="shareid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="bookId", property="bookid", jdbcType=JdbcType.INTEGER),
        @Result(column="shareType", property="sharetype", jdbcType=JdbcType.INTEGER),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastTime", property="lasttime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="discard", property="discard", jdbcType=JdbcType.TINYINT)
    })
    List<ShareRecord> findAll();
}