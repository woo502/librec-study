package com.woo502.recommend.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.woo502.recommend.bo.Book;
import com.woo502.recommend.common.mybatis.BaseMapper;

public interface BookMapper extends BaseMapper {
    @Select({
        "select",
        "bookId, bookName, imgResourceId, audioResourceId, screen, publish, publishTime, ",
        "amount, member, lang, isRead, createUser, outerBookId, editVs, createTime, lastTime, ",
        "discard, remark,",
        "(select tagId from t_tag_record as t2 where tagId in (38,39) and t2.bookId=t1.bookId group by bookId having count(tagId) = 1) as tag",
        "from t_book t1",
        "where isRead = 1 and publish = 1 and discard = 0 and isRead = 1",
        "and not exists (select 1 from t_tag_record t3 where tagId in (9) and t3.bookId=t1.bookId limit 1)",
        "order by bookId"
//        ,"limit 100"
    })
    @Results({
        @Result(column="bookId", property="bookid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="bookName", property="bookname", jdbcType=JdbcType.VARCHAR),
        @Result(column="imgResourceId", property="imgresourceid", jdbcType=JdbcType.INTEGER),
        @Result(column="audioResourceId", property="audioresourceid", jdbcType=JdbcType.INTEGER),
        @Result(column="screen", property="screen", jdbcType=JdbcType.TINYINT),
        @Result(column="publish", property="publish", jdbcType=JdbcType.TINYINT),
        @Result(column="publishTime", property="publishtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="member", property="member", jdbcType=JdbcType.TINYINT),
        @Result(column="lang", property="lang", jdbcType=JdbcType.TINYINT),
        @Result(column="isRead", property="isread", jdbcType=JdbcType.TINYINT),
        @Result(column="createUser", property="createuser", jdbcType=JdbcType.INTEGER),
        @Result(column="outerBookId", property="outerbookid", jdbcType=JdbcType.INTEGER),
        @Result(column="editVs", property="editvs", jdbcType=JdbcType.TINYINT),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastTime", property="lasttime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="discard", property="discard", jdbcType=JdbcType.TINYINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="tag", property="tag", jdbcType=JdbcType.INTEGER)
    })
    List<Book> findAll();
}