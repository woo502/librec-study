package com.woo502.recommend.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.woo502.recommend.bo.BookStatistic;
import com.woo502.recommend.common.mybatis.BaseMapper;

public interface BookStatisticMapper extends BaseMapper {
    @Select({
        "select",
        "dateStr, bookId, bookName, sum(`read`) as `read`, readComplete, forward, collect, listen, readTotal, ",
        "readCompleteTotal, forwardTotal, collectTotal, listenTotal, createTime, lastTime",
        "from t_booklist_day_statistic",
        "where `read` > 0",
        "group by bookId",
        "order by bookId asc"
    })
    @Results({
        @Result(column="dateStr", property="datestr", jdbcType=JdbcType.DATE, id=true),
        @Result(column="bookId", property="bookid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="bookName", property="bookname", jdbcType=JdbcType.VARCHAR),
        @Result(column="read", property="read", jdbcType=JdbcType.INTEGER),
        @Result(column="readComplete", property="readcomplete", jdbcType=JdbcType.INTEGER),
        @Result(column="forward", property="forward", jdbcType=JdbcType.INTEGER),
        @Result(column="collect", property="collect", jdbcType=JdbcType.INTEGER),
        @Result(column="listen", property="listen", jdbcType=JdbcType.INTEGER),
        @Result(column="readTotal", property="readtotal", jdbcType=JdbcType.INTEGER),
        @Result(column="readCompleteTotal", property="readcompletetotal", jdbcType=JdbcType.INTEGER),
        @Result(column="forwardTotal", property="forwardtotal", jdbcType=JdbcType.INTEGER),
        @Result(column="collectTotal", property="collecttotal", jdbcType=JdbcType.INTEGER),
        @Result(column="listenTotal", property="listentotal", jdbcType=JdbcType.INTEGER),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastTime", property="lasttime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BookStatistic> findAll();
}